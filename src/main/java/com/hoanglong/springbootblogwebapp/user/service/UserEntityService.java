package com.hoanglong.springbootblogwebapp.user.service;

import com.hoanglong.springbootblogwebapp.init.enums.GenErrorMessage;
import com.hoanglong.springbootblogwebapp.init.exception.exceptions.ItemNotFoundException;
import com.hoanglong.springbootblogwebapp.init.service.BaseEntityService;
import com.hoanglong.springbootblogwebapp.role.service.RoleEntityService;
import com.hoanglong.springbootblogwebapp.user.entity.User;
import com.hoanglong.springbootblogwebapp.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserEntityService extends BaseEntityService<User, UserRepository> {
    public UserEntityService(UserRepository userRepository){
        super(userRepository);
    }

    public List<User> FindAll(){
        return getDao().findAll();
    }
    public User FindUserByID(UUID id){
        User user = FindById(id);
        return user;
    }
    public UUID DeleteUser(UUID id){
        getDao().deleteById(id);
        return id;
    }
    public void SaveUser(User user){
        getDao().save(user);
    }
    public void UpdateUser(UUID id,User updateUser){
        User user = FindUserByID(id);
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setFullName(user.getFullName());
        user.setActive(updateUser.isActive());
        getDao().save(user);
    }
}
