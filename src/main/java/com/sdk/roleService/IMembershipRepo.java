package com.sdk.roleService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMembershipRepo extends JpaRepository<MembershipModel, Integer> {

    MembershipModel getRoleByTeamidAndUserid(String teamId, String userId);
}
