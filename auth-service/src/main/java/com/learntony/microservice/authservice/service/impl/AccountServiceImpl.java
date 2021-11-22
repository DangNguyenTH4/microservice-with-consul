package com.learntony.microservice.authservice.service.impl;

import com.learntony.microservice.authservice.model.UserEntity;
import com.learntony.microservice.authservice.repository.RoleRepository;
import com.learntony.microservice.authservice.repository.UserRepository;
import com.learntony.microservice.authservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if(userEntity == null){
            log.error("User not found in db: {}", userName);
            throw new UsernameNotFoundException("User not found");
        }else{
            log.info("User found : {}", userName);
        }

        return new User(userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(role ->
                        new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
    }
}
