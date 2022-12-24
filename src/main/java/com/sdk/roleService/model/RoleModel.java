package com.sdk.roleService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
