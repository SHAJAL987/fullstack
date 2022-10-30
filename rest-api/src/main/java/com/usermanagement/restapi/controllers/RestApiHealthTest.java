package com.usermanagement.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestApiHealthTest {
    
    @GetMapping("/admin")
    public String healthChecker(){
        return "API is in Good helth";
    }
}
