package com.sdk.roleService.controller;

public class CreateRoleResponse {

    public String msg;

    public CreateRoleResponse(String roleName) {
        this.msg = roleName + " role created successfully";
    }
}
