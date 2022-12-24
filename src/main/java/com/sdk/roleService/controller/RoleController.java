package com.sdk.roleService.controller;

import com.sdk.roleService.interfaces.IRoleService;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoleController {

    final private IRoleService service;

    public RoleController(IRoleService service) {
        this.service = service;
    }

    @GetMapping("/role")
    public String getRole(@RequestParam(value = "teamId", defaultValue = "World")String teamId, @RequestParam(value = "userId", defaultValue = "World")String userId){
        return service.getRole(teamId, userId);
    }

    @PostMapping("/role/assign")
    public void setRole(@RequestBody MembershipRequest request){
        service.assignRole(request.userId, request.teamId, request.role);
    }

    @PostMapping("/role/create")
    public void createRole(@RequestBody RoleRequest request){
        service.createRole(request.roleName);
    }
}
