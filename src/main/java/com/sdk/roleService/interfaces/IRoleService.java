package com.sdk.roleService.interfaces;

import com.sdk.roleService.controller.AssignRoleResponse;
import com.sdk.roleService.controller.CreateRoleResponse;
import com.sdk.roleService.model.MembershipModel;

import java.io.IOException;
import java.util.List;

public interface IRoleService {

    CreateRoleResponse createRole(String roleName);

    AssignRoleResponse assignRole(String userId, String teamId, String role) throws IOException;

    String getRole(String teamId, String userId) throws IOException;

    List<MembershipModel> getMembershipsByRole(String role);
}
