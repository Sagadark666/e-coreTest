package com.sdk.roleService.service;

import com.sdk.roleService.controller.AssignRoleResponse;
import com.sdk.roleService.controller.CreateRoleResponse;
import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IMainService;
import com.sdk.roleService.interfaces.IValidateLogic;
import com.sdk.roleService.model.MembershipModel;
import com.sdk.roleService.model.RoleModel;

import java.io.IOException;
import java.util.List;

public class MainService implements IMainService {

    private final IRoleRepo roleRepo;
    private final IMembershipRepo membershipRepo;
    private final IValidateLogic logicValidator;

    public MainService(IRoleRepo roleRepo, IMembershipRepo membershipRepo, IValidateLogic logicValidator) {
        this.roleRepo = roleRepo;
        this.membershipRepo = membershipRepo;
        this.logicValidator = logicValidator;
    }

    @Override
    public String getRole(String teamId, String userId) throws IOException {
        try{
            logicValidator.idNotExists("/users/", userId);
            logicValidator.idNotExists("/teams/", teamId);
            logicValidator.userNotInTeam(userId, teamId);
            return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
        }catch (Exception e){
            assignRole(userId, teamId, "DEVELOPER");
            return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
        }
    }

    @Override
    public List<RoleModel> getRoles() {
        return roleRepo.findAll();
    }

    public List<MembershipModel> getMembershipsByRole(String role){
        logicValidator.roleNotExists(role);
        return membershipRepo.findAllByRole(role);
    }

    @Override
    public CreateRoleResponse createRole(String roleName){
        logicValidator.roleAlreadyExists(roleName);
        RoleModel model  = new RoleModel();
        model.setRole(roleName);
        roleRepo.save(model);
        return new CreateRoleResponse(roleName);
    }

    @Override
    public AssignRoleResponse assignRole(String userId, String teamId, String role) throws IOException {
        logicValidator.roleNotExists(role);
        MembershipModel model;
        if(membershipRepo.existsByTeamidAndUserid(teamId, userId)){
             model = membershipRepo.getRoleByTeamidAndUserid(teamId, userId);
        } else {
            logicValidator.idNotExists("/users/", userId);
            logicValidator.idNotExists("/teams/", teamId);
            logicValidator.userNotInTeam(userId, teamId);
            model = new MembershipModel();
            model.setUserid(userId);
            model.setTeamid(teamId);
        }
        model.setRole(role);
        membershipRepo.save(model);
        return new AssignRoleResponse(role, userId, teamId);
    }

}
