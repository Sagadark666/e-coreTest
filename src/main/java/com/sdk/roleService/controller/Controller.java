package com.sdk.roleService.controller;

import com.sdk.roleService.interfaces.IMainService;
import com.sdk.roleService.interfaces.IValidateRequest;
import com.sdk.roleService.model.MembershipModel;
import com.sdk.roleService.model.RoleModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/role")
public class Controller {

    final private IMainService service;
    final private IValidateRequest requestValidator;

    public Controller(IMainService service, IValidateRequest requestValidator) {
        this.service = service;
        this.requestValidator = requestValidator;
    }

    @GetMapping()
    public ResponseEntity<String> getRole(@RequestParam(value = "teamId")String teamId,
                          @RequestParam(value = "userId")String userId) throws IOException {
        requestValidator.emptyField("Team", teamId);
        requestValidator.emptyField("User", userId);
        return new ResponseEntity<>(service.getRole(teamId, userId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleModel>> getRoles(){
        return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/{role-name}")
    public ResponseEntity<List<MembershipModel>> getRole(@PathVariable("role-name")String roleName){
        return new ResponseEntity<>(service.getMembershipsByRole(roleName.toUpperCase()), HttpStatus.OK);
    }

    @PutMapping("/assign")
    public ResponseEntity<AssignRoleResponse> setRole(@RequestBody MembershipRequest request) throws IOException {
        requestValidator.emptyMembershipField(request);
        return new ResponseEntity<>(service.assignRole(request.userId, request.teamId, request.role.toUpperCase()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateRoleResponse> createRole(@RequestBody RoleRequest request){
        requestValidator.emptyRoleField(request);
        return new ResponseEntity<>(service.createRole(request.roleName.toUpperCase()), HttpStatus.CREATED);
    }
}
