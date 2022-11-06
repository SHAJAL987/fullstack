package com.usermanagement.restapi.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.restapi.payloads.UserRoleDto;
import com.usermanagement.restapi.services.UserRoleService;
import java.util.List;

@RestController
@RequestMapping("/user/ur/v1.0")
public class UserRoleController {
    
    private UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // Create User Roles START -------------------------->
    @PostMapping("/createUserRole")
    public ResponseEntity<UserRoleDto> createUserRoles(@Valid @RequestBody UserRoleDto userRoleDto){
        return new ResponseEntity<>(userRoleService.createUserRole(userRoleDto),HttpStatus.CREATED);
    }

    //Get All User Role START -------------------------->
    @GetMapping("/findAllRole")
    public List<UserRoleDto> getAllUserRole(){
        return userRoleService.getAllUserRoles();
    }

    
}
