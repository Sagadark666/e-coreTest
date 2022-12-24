package com.sdk.roleService;

import com.sdk.roleService.handling.ValidationException;
import com.sdk.roleService.interfaces.IDataCallApi;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IValidateLogic;
import com.sdk.roleService.model.RoleModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class FunctionTests {

    @Resource
    private IDataCallApi dataCallApi;
    @Test
    void isApiCallWorking() throws IOException {
        String content = dataCallApi.getContent("/users/371d2ee8-cdf4-48cf-9ddb-04798b79ad9e");

        Assertions.assertEquals(content, "{\"id\": \"371d2ee8-cdf4-48cf-9ddb-04798b79ad9e\", " +
                "\"firstName\": \"Randy\", \"lastName\": \"Funk\", \"displayName\": \"randyFunk\", " +
                "\"avatarUrl\": \"https://cdn.fakercloud.com/avatars/thomasschrijer_128.jpg\", \"location\": " +
                "\"West Ericashire\"}");
    }

}
