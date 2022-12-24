package com.sdk.roleService.controller;

import com.sdk.roleService.interfaces.IRoleService;
import com.sdk.roleService.model.MembershipModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RoleController {

    final private IRoleService service;

    public RoleController(IRoleService service) {
        this.service = service;
    }

    @GetMapping("/role")
    public String getRole(@RequestParam(value = "teamId")String teamId,
                          @RequestParam(value = "userId")String userId){
        return service.getRole(teamId, userId);
    }

    @GetMapping("/role/{role-name}")
    public List<MembershipModel> getRole(@PathVariable("role-name")String roleName){
        return service.getMembershipsByRole(roleName);
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
