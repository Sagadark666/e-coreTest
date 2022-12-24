package com.sdk.roleService.config;

import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IRoleService;
import com.sdk.roleService.interfaces.IValidateRequest;
import com.sdk.roleService.service.RoleService;
import com.sdk.roleService.util.ValidateRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateRequestConfig {

    @Bean
    IValidateRequest iValidateRequest(){
        return new ValidateRequest();
    }

}
