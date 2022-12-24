package com.sdk.roleService.interfaces;

import com.sdk.roleService.controller.MembershipRequest;
import com.sdk.roleService.controller.RoleRequest;

import javax.management.relation.Role;

public interface IValidateRequest {

    public void emptyRoleField(RoleRequest request);

    public void emptyField(String field, String value);

    public void emptyMembershipField(MembershipRequest request);
}
