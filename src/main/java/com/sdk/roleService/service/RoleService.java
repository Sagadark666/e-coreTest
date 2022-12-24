package com.sdk.roleService.service;

import com.sdk.roleService.controller.AssignRoleResponse;
import com.sdk.roleService.controller.CreateRoleResponse;
import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IRoleService;
import com.sdk.roleService.model.MembershipModel;
import com.sdk.roleService.model.RoleModel;
import com.sdk.roleService.util.ValidateLogic;

import java.io.IOException;
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
    // Add Validation of role assignation - ????
    // Add Validation of existing roles - DONE
    // Add Validation of existing assignations - DONE
    // Add Rewrite Assignations of Role - DONE
    // Add ResponseEntities - DONE
    // Add Logic Validations -  DONE - Fix implementation
    // Add Request Validations - DONE
    // Add ExceptionHandlers - Not Applies
    // Review Directory Structure
    // Clean up classes
    // Review if roleServices has to be split
    // Maybe fix return of role String instead Model
    // Add result to assignation
    // Add role/all
    // Add additional info to ResponseEntity for Post and Put
    // Add validation for successfully method
    // Better validations
    // Fuse Validation
    // Create class connection
    // Standardize Capitalization
    // Add UnitTesting
    // Add RestTesting
    // Add DockerIntegration



    public String getRole(String teamId, String userId) throws IOException {
        try{
            ValidateLogic validate = new ValidateLogic(roleRepo);
            validate.userNotExists(userId);
            validate.teamNotExists(teamId);
            validate.userNotInTeam(userId, teamId);
            return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
        }catch (Exception e){
            assignRole(userId, teamId, "Developer");
            return membershipRepo.getRoleByTeamidAndUserid(teamId, userId).getRole();
        }
    }

    public List<MembershipModel> getMembershipsByRole(String role){
        ValidateLogic validate = new ValidateLogic(roleRepo);
        validate.roleNotExists(role);
        return membershipRepo.findAllByRole(role);
    }

    public CreateRoleResponse createRole(String roleName){
        ValidateLogic validate = new ValidateLogic(roleRepo);
        validate.roleAlreadyExists(roleName);
        RoleModel model  = new RoleModel();
        model.setRole(roleName);
        roleRepo.save(model);
        return new CreateRoleResponse(roleName);
    }

    public AssignRoleResponse assignRole(String userId, String teamId, String role) throws IOException {
        ValidateLogic validate = new ValidateLogic(roleRepo);
        validate.roleNotExists(role);
        MembershipModel model;
        if(membershipRepo.existsByTeamidAndUserid(teamId, userId)){
             model = membershipRepo.getRoleByTeamidAndUserid(teamId, userId);
        } else {
            validate.userNotExists(userId);
            validate.teamNotExists(teamId);
            validate.userNotInTeam(userId, teamId);
            model = new MembershipModel();
            model.setUserid(userId);
            model.setTeamid(teamId);
        }
        model.setRole(role);
        membershipRepo.save(model);
        return  new AssignRoleResponse(role, userId, teamId);
    }

}
