package com.sdk.roleService.interfaces;

import com.sdk.roleService.model.MembershipModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMembershipRepo extends JpaRepository<MembershipModel, Integer> {

    MembershipModel getRoleByTeamidAndUserid(String teamId, String userId);
}
