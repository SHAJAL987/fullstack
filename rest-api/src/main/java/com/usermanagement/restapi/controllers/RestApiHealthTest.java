package com.usermanagement.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiHealthTest {
    
    @GetMapping("/")
    public String healthChecker(){
        return "API is in Good helth";
    }
}
