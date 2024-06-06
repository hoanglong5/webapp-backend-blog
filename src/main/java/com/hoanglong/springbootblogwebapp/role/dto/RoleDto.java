package com.hoanglong.springbootblogwebapp.role.dto;

import lombok.*;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class RoleDto {
    private String name;
    private String description;
}
