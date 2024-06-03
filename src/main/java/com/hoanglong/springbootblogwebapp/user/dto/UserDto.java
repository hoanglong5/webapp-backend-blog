package com.hoanglong.springbootblogwebapp.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hoanglong.springbootblogwebapp.role.dto.RoleDto;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import lombok.*;

import java.util.UUID;
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String id;
    private String email;
    private String password;
    private String fullName;
    private boolean isActive;
    private Role role;
}
