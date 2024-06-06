package com.hoanglong.springbootblogwebapp.security.service;

import com.hoanglong.springbootblogwebapp.security.dto.AuthenticationRequest;
import com.hoanglong.springbootblogwebapp.security.dto.AuthenticationResponse;
import com.hoanglong.springbootblogwebapp.security.jwt.JwtGenerator;
import com.hoanglong.springbootblogwebapp.user.dto.UserSaveDto;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import com.hoanglong.springbootblogwebapp.user.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    private final UserService userService;
    private final JwtGenerator jwtGenerator;
    public AuthenticationResponse Authenticate(AuthenticationRequest authenticationRequest){
        User user = userService.FindUserByUserName(authenticationRequest.getUsername());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean isAuthenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
        if (isAuthenticated) {
            String token = jwtGenerator.generateToken(authenticationRequest.getUsername());
            return new AuthenticationResponse(token, true);
        } else {
            return new AuthenticationResponse(null, false);
        }
    }
    public UUID Register(UserSaveDto userSaveDto){
        return userService.CreateNewUser(userSaveDto);
    }
}
