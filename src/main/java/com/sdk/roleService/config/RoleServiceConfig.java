package com.sdk.roleService.config;

import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IRoleService;
import com.sdk.roleService.service.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleServiceConfig {

    @Bean
    IRoleService iRoleService(IRoleRepo iRoleRepo, IMembershipRepo iMembershipRepo){
        return new RoleService(iRoleRepo, iMembershipRepo);
    }

}
