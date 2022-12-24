package com.sdk.roleService.interfaces;

import java.io.IOException;

public interface IValidateLogic {

    public void roleNotExists(String role);

    public void roleAlreadyExists(String role);

    public void idNotExists(String path, String id) throws IOException;

    public void userNotInTeam(String userId, String teamId) throws IOException;
}
