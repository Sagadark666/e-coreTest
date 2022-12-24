package com.sdk.roleService.controller;

import com.sdk.roleService.service.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private static final String template = "Hello, %s!";

    @GetMapping("/role")
    public Role role(@RequestParam(value = "userId", defaultValue = "World")String name){
        return new Role(1, String.format(template, name));
    }

//    @GetMapping("/role/all")
//    public String getEnrollment(@PathVariable("role-name") String role){
//        return role;
//    }

    @GetMapping("/role/all")
    public List<String> getEnrollment(){
        return new Role(1, String.format(template, "name")).getRoles();
    }

    @PostMapping("/role/create")
    public void createRole(@RequestBody RoleRequest request){
        new Role(1, String.format(template, "name")).createRole(request.roleName);
    }
}
