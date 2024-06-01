package com.hoanglong.springbootblogwebapp.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hoanglong.springbootblogwebapp.role.dto.RoleDto;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String email;
    private String password;
    private String fullName;
    private boolean isActive;
    private Role role;
}
