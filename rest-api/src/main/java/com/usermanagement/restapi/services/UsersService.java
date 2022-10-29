package com.usermanagement.restapi.services;

import com.usermanagement.restapi.payloads.UserCreationDto;

public interface UsersService {
    // Create User Service..... START ..........
    UserCreationDto createUser(UserCreationDto userCreationDto);
    // Create User Service..... END ............
}
