package com.sdk.roleService;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBERSHIP")
public class MembershipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String userid;

    public String teamid;

    public String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
