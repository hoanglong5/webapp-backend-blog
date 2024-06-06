package com.hoanglong.springbootblogwebapp.security.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private boolean isAuthenticated;
}
