package com.sdk.roleService;

public class RoleAssignTest {

    private final String userId;
    private final String teamId;
    private final String role;

    public RoleAssignTest(String userId, String teamId, String role) {
        this.userId = userId;
        this.teamId = teamId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getRole() {
        return role;
    }
}
