package com.learntony.microservice.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
    private Long id;
    private String name;
}
