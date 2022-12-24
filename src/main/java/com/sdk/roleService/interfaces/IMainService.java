package com.sdk.roleService.interfaces;

import com.sdk.roleService.controller.AssignRoleResponse;
import com.sdk.roleService.controller.CreateRoleResponse;
import com.sdk.roleService.model.MembershipModel;
import com.sdk.roleService.model.RoleModel;

import java.io.IOException;
import java.util.List;

public interface IMainService {

    List<RoleModel> getRoles();

    CreateRoleResponse createRole(String roleName);

    List<MembershipModel> getMembershipsByRole(String role);

    String getRole(String teamId, String userId) throws IOException;

    AssignRoleResponse assignRole(String userId, String teamId, String role) throws IOException;






}
