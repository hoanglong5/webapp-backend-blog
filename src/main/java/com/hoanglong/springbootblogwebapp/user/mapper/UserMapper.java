package com.hoanglong.springbootblogwebapp.user.mapper;

import com.hoanglong.springbootblogwebapp.user.dto.UserDto;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper()
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    //UserDto
    UserDto usertoUserDto(User user);
    List<UserDto> listUserToListUserDto(List<User> users);
}
