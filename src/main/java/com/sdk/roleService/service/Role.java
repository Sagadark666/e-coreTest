package com.sdk.roleService.service;

import java.util.ArrayList;
import java.util.List;

public class Role {

    private final long id;
    private final String content;

    private List<String> roles;

    public Role(long id, String content) {
        this.id = id;
        this.content = content;
        this.roles = new ArrayList<>();
        roles.add("Developer");
        roles.add("Product Owner");
        roles.add("Tester");
    }

    public Role getMembership(){

        return new Role(1, "a");
    }
    public Role[] getRole(){
        Role[] temp = new Role[1];
        temp[0] = new Role(1, "a");
        return temp;
    }

    public List<String> getRoles(){
        return roles;
    }

    public void createRole(String roleName){
        roles.add(roleName);
        System.out.println(roles);
    }

    public void assignRole(){


    }



}
