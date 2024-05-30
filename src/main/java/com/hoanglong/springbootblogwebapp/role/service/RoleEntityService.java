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
    public List<Role> FindAllRole(){
        return getDao().findAll();
    }
    public Role FindRoleById(UUID uuid){
        Role role = FindById(uuid);
        return role;
    }
    public void DeleteRole(UUID id){
        Role role = FindById(id);
        getDao().delete(role);;
    }
    public void SaveRole(Role role){
        getDao().save(role);
    }
    public void UpdateRole(UUID id,Role role){
        Role roleToUpdate = FindRoleById(id);
        roleToUpdate.setDescription(role.getDescription());
        roleToUpdate.setName(role.getName());
        getDao().save(roleToUpdate);
    }
}
