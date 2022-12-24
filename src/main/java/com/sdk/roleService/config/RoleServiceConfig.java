package com.sdk.roleService.config;

import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IMainService;
import com.sdk.roleService.interfaces.IValidateLogic;
import com.sdk.roleService.service.MainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleServiceConfig{

    @Bean
    IMainService iRoleService(IRoleRepo iRoleRepo, IMembershipRepo iMembershipRepo, IValidateLogic iValidateLogic){
        return new MainService(iRoleRepo, iMembershipRepo, iValidateLogic);
    }

}
