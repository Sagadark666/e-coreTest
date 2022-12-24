package com.sdk.roleService.interfaces;

import com.sdk.roleService.model.RoleModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<RoleModel, Integer> {

    boolean existsByRole(String role);

}
