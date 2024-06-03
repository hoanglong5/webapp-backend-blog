package com.hoanglong.springbootblogwebapp.user.service;

import com.hoanglong.springbootblogwebapp.role.entity.Role;
import com.hoanglong.springbootblogwebapp.role.service.RoleEntityService;
import com.hoanglong.springbootblogwebapp.user.dto.UserDto;
import com.hoanglong.springbootblogwebapp.user.dto.UserSaveDto;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import com.hoanglong.springbootblogwebapp.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserEntityService userEntityService;
    private final RoleEntityService roleEntityService;
    public List<UserDto> FindAllUser(){
        List<User> users = userEntityService.FindAll();
        List<UserDto> userDtos = UserMapper.INSTANCE.listUserToListUserDto(users);
        LOGGER.info("fetched users: {}",users);
        return userDtos;
    }
    public UUID CreateNewUser(UserSaveDto userSaveDto){
        User userInfo = new User();
        userInfo.setEmail(userSaveDto.getEmail());
        userInfo.setPassword(userSaveDto.getPassword());
        userInfo.setFullName(userSaveDto.getFullName());
        userInfo.setActive(userSaveDto.isActive());
        userInfo.setCreatedDate(LocalDate.now());
        userInfo.setCreatedBy(null);
        userInfo.setModifiedDate(LocalDate.now());
        userInfo.setModifiedBy(null);
        Role role = roleEntityService.FindById(userSaveDto.getRoleId());
        userInfo.setRole(role);
        userEntityService.SaveUser(userInfo);
        return userInfo.getId();
    }
}
