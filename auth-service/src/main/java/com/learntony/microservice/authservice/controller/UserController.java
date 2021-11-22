package com.learntony.microservice.authservice.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.authservice.dto.request.AddRole2UserRequest;
import com.learntony.microservice.authservice.model.RoleEntity;
import com.learntony.microservice.authservice.model.UserEntity;
import com.learntony.microservice.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserController {
    @Value("${security.secret.key:secret}")
    private String secretKey;

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleEntity> saveRole(@RequestBody RoleEntity role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody AddRole2UserRequest form) {
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String token,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (StringUtils.startsWith(token, "Bearer ")) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secretKey);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String userName = decodedJWT.getSubject();
                UserEntity userEntity = userService.getUser(userName);
                String accessToken = JWT.create()
                        .withSubject(userEntity.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> responseToken = new HashMap<>();
                responseToken.put("access_token", accessToken);
                responseToken.put("refresh_token", token.substring("Bearer ".length()));
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), responseToken);
            } catch (Exception ex) {
                log.error("Error loggin in :{}", ex.getMessage());
                response.setHeader("error", ex.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                Map<String, String> error = new HashMap<>();
                error.put("error_message", ex.getMessage());
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
