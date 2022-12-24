package com.sdk.roleService.service;

import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IRoleService;
import com.sdk.roleService.model.MembershipModel;
import com.sdk.roleService.model.RoleModel;

import java.util.List;

public class RoleService implements IRoleService {

    private final IRoleRepo roleRepo;
    private final IMembershipRepo membershipRepo;

    public RoleService(IRoleRepo roleRepo, IMembershipRepo membershipRepo) {
        this.roleRepo = roleRepo;
        this.membershipRepo = membershipRepo;
    }

    public String getRole(String teamId, String userId){
        return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
    }

    public List<MembershipModel> getMembershipsByRole(String role){
        return membershipRepo.findAllByRole(role);
    }

    public void createRole(String roleName){
        RoleModel model  = new RoleModel();
        model.setRole(roleName);
        roleRepo.save(model);
    }

    public void assignRole(String userId, String teamId, String role){
        MembershipModel model = new MembershipModel();
        model.setUserid(userId);
        model.setTeamid(teamId);
        model.setRole(role);
        membershipRepo.save(model);
    }


}
