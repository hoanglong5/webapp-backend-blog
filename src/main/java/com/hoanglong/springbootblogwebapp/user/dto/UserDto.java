package com.hoanglong.springbootblogwebapp.user.dto;


import com.hoanglong.springbootblogwebapp.role.entity.Role;
import lombok.*;

import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private UUID id;
    private String email;
    private String fullName;
    private boolean isActive;
    private Role role;
}
