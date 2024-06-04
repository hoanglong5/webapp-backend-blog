package com.hoanglong.springbootblogwebapp.role.service;

import com.hoanglong.springbootblogwebapp.role.dto.RoleDto;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import com.hoanglong.springbootblogwebapp.role.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleEntityService roleEntityService;
    public List<RoleDto> FindAllRole(){
        List<Role> role = roleEntityService.FindAll();
        List<RoleDto> roleDtos = RoleMapper.INSTANCE.listRoleToListRoleDto(role);
        return roleDtos;
    }
    public RoleDto FindRoleByID(UUID uuid){
        Role role = roleEntityService.FindById(uuid);
        RoleDto roleDto = RoleMapper.INSTANCE.roleToRoleDto(role);
        return roleDto;
    }
    public UUID SaveNewRole(Role role){
        roleEntityService.Save(role);
        return role.getId();
    }
    public UUID DeleteRole(UUID uuid){
        roleEntityService.Delete(uuid);
        return uuid;
    }
    public UUID UpdateNewRole(Role role,UUID uuid){
        roleEntityService.Update(uuid,role);
        return uuid;
    }
}
