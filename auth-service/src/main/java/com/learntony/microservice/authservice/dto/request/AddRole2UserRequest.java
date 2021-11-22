package com.learntony.microservice.authservice.dto.request;

import lombok.Data;

@Data
public class AddRole2UserRequest {
    private String userName;
    private String roleName;
}
