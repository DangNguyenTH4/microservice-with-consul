package com.learntony.microservice.authservice.security.filter;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CustomerAuthorizationFilter extends OncePerRequestFilter {
    @Value("${security.secret.key:secret}")
    private String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().contains("api/login") || request.getServletPath().contains("/api/token/refresh")) {
            filterChain.doFilter(request, response);
        } else {

            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            //TODO check in cached
            if (StringUtils.startsWith(authorizationHeader, "Bearer ")) {
                try {
                    Algorithm algorithm = Algorithm.HMAC256(secretKey);
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(authorizationHeader);
                    String userName = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    Collection<SimpleGrantedAuthority> authorities = Stream.of(roles).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userName, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    //TODO put to cached
                }catch (Exception ex){
                    log.error("Error loggin in :{}", ex.getMessage());
                    response.setHeader("error", ex.getMessage());
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    Map<String, String> error = new HashMap<>();
                    error.put("error_message", ex.getMessage());
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                    //stop filter if have any error
                    return;
                }
            }
            filterChain.doFilter(request, response);
        }

    }
}
