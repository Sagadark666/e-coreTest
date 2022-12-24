package com.sdk.roleService.controller;

public class AssignRoleResponse {

    public String msg;

    public AssignRoleResponse(String roleName, String userId, String teamId) {
        this.msg = "Role: "+ roleName + "assigned successfully to user id: "+userId + " in team id: "+teamId;
    }
}
