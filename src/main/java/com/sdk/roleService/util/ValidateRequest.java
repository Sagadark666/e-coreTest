package com.sdk.roleService.util;

import com.sdk.roleService.handling.ValidationException;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.service.ValidationService;

import java.io.IOException;

public class ValidateRequest {

    private final IRoleRepo roleRepo;

    public ValidateRequest(IRoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public void roleNotExists(String role){
        if(!roleRepo.existsByRole(role)){
            throw new ValidationException(role +" is not an allowed Role. " +
                    "Please check the list of allowed roles with /role/all. " +
                    "Alternatively you can submit a new role with /role/create.");
        }
    }

    public void roleAlreadyExists(String role){
        if(roleRepo.existsByRole(role)){
            throw new ValidationException("Role: "+ role +" is already created.");
        }
    }

    public void userNotExists(String userId) throws IOException {
        ValidationService validationService = new ValidationService();
        if(!validationService.userExists(userId)){
            throw new ValidationException("User: "+ userId +" does not exists.");
        }
    }

    public void teamNotExists(String teamId) throws IOException {
        ValidationService validationService = new ValidationService();
        if(!validationService.teamExists(teamId)){
            throw new ValidationException("Team: "+ teamId +" does not exists.");
        }

    }

    public void userNotInTeam(String userId, String teamId) throws IOException {
        ValidationService validationService = new ValidationService();
        if(!validationService.isUserInTeam(userId, teamId)){
            throw new ValidationException("User "+ userId +" does not belong to team "+ teamId);
        }
    }

}
