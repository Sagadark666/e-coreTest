package com.sdk.roleService.config;

import com.sdk.roleService.connection.DataCallApi;
import com.sdk.roleService.interfaces.IDataCallApi;
import com.sdk.roleService.interfaces.IValidateRequest;
import com.sdk.roleService.util.ValidateRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataCallApiConfig {

    @Bean
    IDataCallApi iDataCallApi(){
        return new DataCallApi();
    }

}
