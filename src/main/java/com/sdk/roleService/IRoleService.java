package com.sdk.roleService;

public interface IRoleService {

    void createRole(String roleName);

    void assignRole(String userId, String teamId, String role);

    public String getRole(String teamId, String userId);
}
