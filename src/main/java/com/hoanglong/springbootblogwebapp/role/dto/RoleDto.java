package com.hoanglong.springbootblogwebapp.role.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private String name;
    private String description;
}
