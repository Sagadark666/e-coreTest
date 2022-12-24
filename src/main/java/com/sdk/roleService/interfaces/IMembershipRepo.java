package com.sdk.roleService.interfaces;

import com.sdk.roleService.model.MembershipModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMembershipRepo extends JpaRepository<MembershipModel, Integer> {

    MembershipModel getRoleByTeamidAndUserid(String teamId, String userId);

    List<MembershipModel> findAllByRole(String role);
}
