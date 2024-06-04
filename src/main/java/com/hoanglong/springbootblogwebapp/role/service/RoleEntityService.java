package com.hoanglong.springbootblogwebapp.role.service;

import com.hoanglong.springbootblogwebapp.init.service.BaseEntityService;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import com.hoanglong.springbootblogwebapp.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleEntityService extends BaseEntityService<Role, RoleRepository> {
    public RoleEntityService(RoleRepository dao) {
        super(dao);
    }
    public void Delete(UUID id){
        Role role = FindById(id);
        getDao().delete(role);;
    }
    public void Update(UUID id, Role role){
        Role roleToUpdate = FindById(id);
        roleToUpdate.setDescription(role.getDescription());
        roleToUpdate.setName(role.getName());
        getDao().save(roleToUpdate);
    }
}
