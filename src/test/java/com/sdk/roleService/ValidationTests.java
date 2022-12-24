package com.sdk.roleService;

import com.sdk.roleService.handling.ValidationException;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IValidateLogic;
import com.sdk.roleService.model.RoleModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ValidationTests {

    @Test
    void contextDoesLoads() {
    }

    @Resource
    private IRoleRepo roleRepo;
    @Resource
    private IValidateLogic logicValidator;

    @Test
    void checkIdValidation(){
        final Exception e = assertThrows(ValidationException.class,
                () -> {
                    logicValidator.idNotExists("/users/","non-existent-id");
                }
        );
        Assertions
                .assertEquals("/users/non-existent-id does not exists.",
                        e.getMessage());

    }

    @Test
    void checkUserTeamValidation(){
        final Exception e = assertThrows(ValidationException.class,
                () -> {
                    logicValidator.userNotInTeam("non-existent-id", "7676a4bf-adfe-415c-941b-1739af07039b");
                }
        );
        Assertions
                .assertEquals("User non-existent-id does not belong to team 7676a4bf-adfe-415c-941b-1739af07039b",
                        e.getMessage());
    }

    @Test
    void checkRoleExistsValidation(){
        RoleModel roleModel = new RoleModel();
        roleModel.role = "TESTROLE";
        roleRepo.save(roleModel);
        final Exception e = assertThrows(ValidationException.class,
                () -> {
                    logicValidator.roleAlreadyExists("TESTROLE");
                }
        );
        Assertions
                .assertEquals("Role: TESTROLE is already created.",
                        e.getMessage());
    }

    @Test
    void checkRoleNotExistsValidation(){
        final Exception e = assertThrows(ValidationException.class,
                () -> {
                    logicValidator.roleNotExists("TESTROLE");
                }
        );
        Assertions
                .assertEquals("TESTROLE is not an allowed Role. Please check the list of allowed roles with /role/all. " +
                                "Alternatively you can submit a new role with /role/create.",
                        e.getMessage());
    }

}
