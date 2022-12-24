package com.sdk.roleService.service;

import com.sdk.roleService.handling.ValidationException;
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

    //TODO
    // Add Defaulter for all memberships - DONE - But Burned "Developer"
    // Add Validation of role assignation - DONE
    // Add Validation of existing roles
    // Add Validation of existing assignations
    // Add Rewrite Assignations of Role
    // Add ResponseEntities
    // Add ExceptionHandlers
    // Add UnitTesting
    // Add RestTesting
    // Add DockerIntegration
    // Review Directory Structure
    // Clean up classes
    // Review if roleServices has to be split
    // Maybe fix return of role String instead Model
    // Add result to assignation

    public String getRole(String teamId, String userId){
        try{
            return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
        }catch (Exception e){
            assignRole(userId, teamId, "Developer");
            return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
        }
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
        MembershipModel model;
        if(!roleRepo.existsByRole(role)){
            throw new ValidationException(role +" is not an allowed Role. " +
                    "Please check the list of allowed roles with /role/all. " +
                    "Alternatively you can submit a new role with /role/create.");
        }
        if(membershipRepo.existsByTeamidAndUserid(teamId, userId)){
             model = membershipRepo.getRoleByTeamidAndUserid(teamId, userId);
        } else {
            model = new MembershipModel();
            model.setUserid(userId);
            model.setTeamid(teamId);
        }
        model.setRole(role);
        membershipRepo.save(model);
    }

}
