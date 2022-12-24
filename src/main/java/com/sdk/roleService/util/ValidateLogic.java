package com.sdk.roleService.util;

import com.sdk.roleService.handling.ValidationException;
import com.sdk.roleService.interfaces.IDataCallApi;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IValidateLogic;;

import java.io.IOException;

public class ValidateLogic implements IValidateLogic {

    private final IRoleRepo roleRepo;
    private final IDataCallApi dataCallApi;

    public ValidateLogic(IRoleRepo roleRepo, IDataCallApi dataCallApi) {
        this.roleRepo = roleRepo;
        this.dataCallApi = dataCallApi;
    }

    @Override
    public void roleNotExists(String role){
        if(!roleRepo.existsByRole(role)){
            throw new ValidationException(role +" is not an allowed Role. " +
                    "Please check the list of allowed roles with /role/all. " +
                    "Alternatively you can submit a new role with /role/create.");
        }
    }

    @Override
    public void roleAlreadyExists(String role){
        if(roleRepo.existsByRole(role)){
            throw new ValidationException("Role: "+ role +" is already created.");
        }
    }

    @Override
    public void idNotExists(String path, String id) throws IOException {
        if(dataCallApi.getContent(path+id).equals("null")){
            throw new ValidationException(path + id +" does not exists.");
        }
    }

    @Override
    public void userNotInTeam(String userId, String teamId) throws IOException {
        if(!dataCallApi.getContent("/teams/"+teamId).contains(userId)){
            throw new ValidationException("User "+ userId +" does not belong to team "+ teamId);
        }
    }
}
