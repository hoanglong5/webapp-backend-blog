package com.hoanglong.springbootblogwebapp.user.service;


import com.hoanglong.springbootblogwebapp.init.service.BaseEntityService;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import com.hoanglong.springbootblogwebapp.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserEntityService extends BaseEntityService<User, UserRepository> {
    public UserEntityService(UserRepository userRepository){
        super(userRepository);
    }
    public UUID DeleteUser(UUID id){
        getDao().deleteById(id);
        return id;
    }
    public UUID CreateUser(User user){
        getDao().save(user);
        return user.getId();
    }
    public UUID UpdateUser(UUID id,User updateUser){
        User user = FindById(id);
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setFullName(updateUser.getFullName());
        user.setActive(updateUser.isActive());
        getDao().save(user);
        return id;
    }
}
