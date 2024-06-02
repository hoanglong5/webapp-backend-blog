package com.hoanglong.springbootblogwebapp.user.controller;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import com.hoanglong.springbootblogwebapp.init.enums.MessageResponse;
import com.hoanglong.springbootblogwebapp.user.dto.UserDto;
import com.hoanglong.springbootblogwebapp.user.dto.UserSaveDto;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import com.hoanglong.springbootblogwebapp.user.service.UserEntityService;
import com.hoanglong.springbootblogwebapp.user.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/${application.version}/user")
@AllArgsConstructor
public class UserController {
    private final UserEntityService userEntityService;
    private final UserService userService;
//    @GetMapping()
//    public ResponseEntity<RestResponse<List<UserDto>>> FindAllUser(){
//        RestResponse<List<UserDto>> response = RestResponse.of(userService.FindAllUser());
//        response.setMessage(MessageResponse.SUCCESSFULLY_FINDALL.getMessage());
//        return ResponseEntity.ok(response);
//    }
    @GetMapping()
    public ResponseEntity<RestResponse<List<User>>> FindAllUser(){
        RestResponse<List<User>> response = RestResponse.of(userEntityService.FindAll());
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDALL.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<RestResponse<User>> FindUserById(@PathVariable UUID uuid){
        RestResponse<User> response = RestResponse.of(userEntityService.FindUserByID(uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDBYID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<RestResponse<?>> DeleteUser(@PathVariable UUID uuid){
        userEntityService.DeleteUser(uuid);
        RestResponse<?> response = RestResponse.empty();
        response.setMessage(MessageResponse.SUCCESSFULLY_DELETE.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<UUID>> SaveUser(@RequestBody UserSaveDto userSaveDto){
        RestResponse<UUID> response = RestResponse.of(userService.CreateNewUser(userSaveDto));
        response.setMessage(MessageResponse.SUCCESSFULLY_CREATED.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<RestResponse<?>> UpdateUser(@PathVariable UUID uuid,@RequestBody User user){
        userEntityService.UpdateUser(uuid,user);
        RestResponse<?> response = RestResponse.empty();
        response.setMessage(MessageResponse.SUCCESSFULLY_UPDATED.getMessage());
        return ResponseEntity.ok(response);
    }
}
