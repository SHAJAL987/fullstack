package com.usermanagement.restapi.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.restapi.payloads.UserCreationDto;
import com.usermanagement.restapi.services.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    // Create User START ----------------------->
    @PostMapping("/create")
    public ResponseEntity<UserCreationDto> createUser(@RequestBody UserCreationDto userCreationDto){
        return new ResponseEntity<>(usersService.createUser(userCreationDto),HttpStatus.CREATED);
    }


    //Get All User START ------------------------>
    @GetMapping("/findAllUser")
    public List<UserCreationDto> getAllUsers(){
        return usersService.getAllUsers();
    }

    //Get User By Id  START --------------------->
    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserCreationDto> getUserById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(usersService.getUserById(id));
    }

}
