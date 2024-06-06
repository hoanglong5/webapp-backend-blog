package com.hoanglong.springbootblogwebapp.security.controller;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import com.hoanglong.springbootblogwebapp.init.enums.MessageResponse;
import com.hoanglong.springbootblogwebapp.security.dto.AuthenticationRequest;
import com.hoanglong.springbootblogwebapp.security.dto.AuthenticationResponse;
import com.hoanglong.springbootblogwebapp.security.service.AuthenticationService;
import com.hoanglong.springbootblogwebapp.user.dto.UserSaveDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/${application.version}/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/login")
        public ResponseEntity<RestResponse<AuthenticationResponse>> Login(@RequestBody AuthenticationRequest request){
            return ResponseEntity.ok(RestResponse.of(authenticationService.Authenticate(request)));
    }
    @PostMapping("/register")
        public ResponseEntity<RestResponse<UUID>> Register(@RequestBody UserSaveDto userSaveDto){
        RestResponse<UUID> response = RestResponse.of(authenticationService.Register(userSaveDto));
        response.setMessage(MessageResponse.SUCCESSFULLY_CREATED.getMessage());
        return ResponseEntity.ok(response);
    }
}
