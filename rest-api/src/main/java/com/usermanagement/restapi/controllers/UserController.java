package com.usermanagement.restapi.controllers;

import java.util.List;

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

import com.usermanagement.restapi.payloads.UserCreationDto;
import com.usermanagement.restapi.services.UserService;

@RestController
@RequestMapping("/user/v1.0")
public class UserController {

    private UserService usersService;

    public UserController(UserService usersService) {
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

    //Update User By Id START ------------------->
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserCreationDto> updateUserById(@RequestBody UserCreationDto userCreationDto, @PathVariable(name = "id") long id){
        UserCreationDto userResponse = usersService.updateUser(userCreationDto, id);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    //Delete User By Id START ------------------->
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable(name = "id") long id ){
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }

}
