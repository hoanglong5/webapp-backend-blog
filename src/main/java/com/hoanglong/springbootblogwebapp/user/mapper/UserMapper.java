package com.hoanglong.springbootblogwebapp.user.mapper;

import com.hoanglong.springbootblogwebapp.user.dto.UserDto;
import com.hoanglong.springbootblogwebapp.user.dto.UserSaveDto;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    //UserDto
    UserDto UsertoUserDto(User user);
    List<UserDto> ListUserToListUserDto(List<User> users);
    //UpdateDto
    //SaveDto
    UserSaveDto UserToUserSaveDto (User user);
}
