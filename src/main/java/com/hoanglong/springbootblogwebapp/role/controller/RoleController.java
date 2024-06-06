package com.hoanglong.springbootblogwebapp.role.controller;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import com.hoanglong.springbootblogwebapp.init.enums.MessageResponse;
import com.hoanglong.springbootblogwebapp.role.dto.RoleDto;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import com.hoanglong.springbootblogwebapp.role.service.RoleEntityService;
import com.hoanglong.springbootblogwebapp.role.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/${application.version}/role")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;
    @GetMapping
    public ResponseEntity<RestResponse<List<RoleDto>>> GetAllRole(){
        RestResponse<List<RoleDto>> response = RestResponse.of(roleService.FindAllRole());
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDALL.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<RestResponse<RoleDto>> FindRoleById(@PathVariable UUID uuid){
        RestResponse<RoleDto> response = RestResponse.of(roleService.FindRoleByID(uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDBYID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<UUID>> CreateRole(@RequestBody Role role){
        RestResponse<UUID> response = RestResponse.of(roleService.SaveNewRole(role));
        response.setMessage(MessageResponse.SUCCESSFULLY_UPDATED.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<RestResponse<UUID>> DeleteRole(@PathVariable UUID uuid){
        RestResponse<UUID> response = RestResponse.of(roleService.DeleteRole(uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_DELETE.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<RestResponse<UUID>> UpdateRole(@RequestBody Role role,@PathVariable UUID uuid){
        RestResponse<UUID> response = RestResponse.of(roleService.UpdateNewRole(role,uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_UPDATED.getMessage());
        return ResponseEntity.ok(response);
    }
}
