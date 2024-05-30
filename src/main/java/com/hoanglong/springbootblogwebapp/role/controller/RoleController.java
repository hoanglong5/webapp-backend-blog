package com.hoanglong.springbootblogwebapp.role.controller;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import com.hoanglong.springbootblogwebapp.init.enums.MessageResponse;
import com.hoanglong.springbootblogwebapp.role.entity.Role;
import com.hoanglong.springbootblogwebapp.role.service.RoleEntityService;
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
    @GetMapping
    public ResponseEntity<RestResponse<List<Role>>> GetAllRole(){
        RestResponse<List<Role>> response = RestResponse.of(roleEntityService.FindAllRole());
        response.setMessage("List role");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<RestResponse<?>> FindRoleById(@PathVariable UUID uuid){
        roleEntityService.FindRoleById(uuid);
        RestResponse<?> response = RestResponse.empty();
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
