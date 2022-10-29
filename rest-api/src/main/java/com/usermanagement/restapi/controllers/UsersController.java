package com.usermanagement.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public ResponseEntity<UserCreationDto> createUser(@RequestBody UserCreationDto userCreationDto){
        return new ResponseEntity<>(usersService.createUser(userCreationDto),HttpStatus.CREATED);
    }
}
