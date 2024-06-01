package com.hoanglong.springbootblogwebapp.role.controller;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import com.hoanglong.springbootblogwebapp.init.enums.MessageResponse;
import com.hoanglong.springbootblogwebapp.role.dto.RoleDto;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import com.hoanglong.springbootblogwebapp.role.service.RoleEntityService;
import com.hoanglong.springbootblogwebapp.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/${application.version}/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleEntityService roleEntityService;
    private final RoleService roleService;
    @GetMapping
    public ResponseEntity<RestResponse<List<RoleDto>>> GetAllRole(){
        RestResponse<List<RoleDto>> response = RestResponse.of(roleService.FindAllRole());
        response.setMessage("List role");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<RestResponse<RoleDto>> FindRoleById(@PathVariable UUID uuid){
        RestResponse<RoleDto> response = RestResponse.of(roleService.FindRoleByID(uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDBYID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<?>> CreateRole(@RequestBody Role role){
        roleEntityService.SaveRole(role);
        RestResponse<?> response = RestResponse.empty();
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDALL.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<RestResponse<?>> DeleteRole(@PathVariable UUID uuid){
        roleEntityService.DeleteRole(uuid);
        RestResponse<?> response = RestResponse.empty();
        response.setMessage(MessageResponse.SUCCESSFULLY_DELETE.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<RestResponse<?>> UpdateRole(@RequestBody Role role,@PathVariable UUID uuid){
        roleEntityService.UpdateRole(uuid,role);
        RestResponse<?> response = RestResponse.empty();
        response.setMessage(MessageResponse.SUCCESSFULLY_UPDATED.getMessage());
        return ResponseEntity.ok(response);
    }

}
