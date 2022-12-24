package com.sdk.roleService.interfaces;

import com.sdk.roleService.controller.AssignRoleResponse;
import com.sdk.roleService.controller.CreateRoleResponse;
import com.sdk.roleService.model.MembershipModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface IValidationService {

    public boolean userExists(String userId) throws IOException;

    public boolean teamExists(String teamId) throws IOException;

    public boolean isUserInTeam(String userId, String teamId) throws IOException;
}
