package com.hoanglong.springbootblogwebapp.role.mapper;

import com.hoanglong.springbootblogwebapp.role.dto.RoleDto;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper()
//componentModel = "spring",
//unmappedTargetPolicy = ReportingPolicy.IGNORE
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDto roleToRoleDto(Role role);
    List<RoleDto> listRoleToListRoleDto(List<Role> roles);
}
