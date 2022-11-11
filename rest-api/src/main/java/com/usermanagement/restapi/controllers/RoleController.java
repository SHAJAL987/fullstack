package com.usermanagement.restapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.restapi.payloads.RoleDto;
import com.usermanagement.restapi.services.RoleService;

@RestController
@RequestMapping("/user/r/v1.0")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Create Role START ----------------------->
    @PostMapping("/create")
    public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.createRole(roleDto),HttpStatus.CREATED);
    }

    //Get All Role START ---------------------->
    @GetMapping("/findAllRole")
    public List<RoleDto> getAllRoles(){
        return roleService.getAllRoles();
    }

    //Get All Role By Id START ------------------>
    @GetMapping("/findAllRoleId/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    //Update Role By Id START ------------------>
    @PutMapping("/updateByRoleId/")
    public ResponseEntity<RoleDto> updateRoleById(@RequestBody RoleDto roleDto, @PathVariable(name = "id") long id){
        RoleDto roleDtoResponse = roleService.updateRole(roleDto, id);
        return new ResponseEntity<>(roleDtoResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoleById/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>("Role Deleted Successfully",HttpStatus.OK);
    }
    

}
