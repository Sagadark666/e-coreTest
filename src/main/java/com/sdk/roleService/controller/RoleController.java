package com.sdk.roleService.controller;

import com.sdk.roleService.service.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private static final String template = "Hello, %s!";

    @GetMapping("/role")
    public Role role(@RequestParam(value = "userId", defaultValue = "World")String name){
        return new Role(1, String.format(template, name));
    }
}
