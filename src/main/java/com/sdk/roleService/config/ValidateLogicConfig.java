package com.sdk.roleService.config;

import com.sdk.roleService.interfaces.IDataCallApi;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IValidateLogic;
import com.sdk.roleService.interfaces.IValidateRequest;
import com.sdk.roleService.util.ValidateLogic;
import com.sdk.roleService.util.ValidateRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateLogicConfig {

    @Bean
    IValidateLogic iValidateLogic(IRoleRepo iRoleRepo, IDataCallApi iDataCallApi){
        return new ValidateLogic(iRoleRepo, iDataCallApi);
    }

}
