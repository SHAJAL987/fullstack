package com.usermanagement.restapi.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //Update User Role By Id START --------------------->
    @PutMapping("/updateUserRole/{id}")
    public ResponseEntity<UserRoleDto> updateUserRole(@RequestBody UserRoleDto userRoleDto, @PathVariable(name = "id") long id){
        UserRoleDto userRoleResponse = userRoleService.updateUserRole(userRoleDto, id);
        return new ResponseEntity<>(userRoleResponse,HttpStatus.OK);
    }

    //Delete User By Id START ------------------->
    public ResponseEntity<String> deleteUserRoleById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>("User Role Deleted Successfully",HttpStatus.OK);
    }

    
}
