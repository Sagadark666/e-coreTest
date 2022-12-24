package com.sdk.roleService.util;

import com.sdk.roleService.controller.MembershipRequest;
import com.sdk.roleService.controller.RoleRequest;
import com.sdk.roleService.handling.ValidationException;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IValidateRequest;
import com.sdk.roleService.service.ValidationService;

import java.io.IOException;

public class ValidateRequest implements IValidateRequest{

    @Override
    public void emptyMembershipField(MembershipRequest request) {
        String output = " field cannot be empty";

        if(request.teamId.isBlank()){
            throw new ValidationException("Team"+output);
        }
        if(request.userId.isBlank()){
            throw new ValidationException("User"+output);
        }
        if(request.role.isBlank()){
            throw new ValidationException("Role"+output);
        }
    }

    @Override
    public void emptyRoleField(RoleRequest request) {
        if(request.roleName.isBlank()){
            throw new ValidationException("Role field cannot be empty");
        }
    }

    @Override
    public void emptyField(String field, String value) {
        if(value.isBlank()){
            throw new ValidationException(field + " field cannot be empty");
        }
    }
}
