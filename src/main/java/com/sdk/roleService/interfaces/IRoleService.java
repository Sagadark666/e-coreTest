package com.sdk.roleService.interfaces;

import com.sdk.roleService.model.MembershipModel;

import java.util.List;

public interface IRoleService {

    void createRole(String roleName);

    void assignRole(String userId, String teamId, String role);

    String getRole(String teamId, String userId);

    List<MembershipModel> getMembershipsByRole(String role);
}
