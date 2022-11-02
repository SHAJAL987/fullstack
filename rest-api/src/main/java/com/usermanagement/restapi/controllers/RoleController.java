package com.usermanagement.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.createRole(roleDto),HttpStatus.CREATED);
    }

}
