package com.hoanglong.springbootblogwebapp.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDto {
    private String email;
    private String password;
    private String fullName;
    private boolean isActive;
    private UUID roleId;
}
