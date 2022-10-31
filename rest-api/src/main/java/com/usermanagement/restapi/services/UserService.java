package com.usermanagement.restapi.services;

import java.util.List;

import com.usermanagement.restapi.payloads.UserCreationDto;

public interface UserService {
    // Create User Service..... START ..........
    UserCreationDto createUser(UserCreationDto userCreationDto);

    // Get All Users Service..... START ..........
    List<UserCreationDto> getAllUsers();

    // Get User By Id Service..... START ..........
    UserCreationDto getUserById(long user_id);

    //Update User .......... START ................
    UserCreationDto updateUser(UserCreationDto userCreationDto, long user_id);

    //Delete User .......... START ...............
    void deleteUserBuId(long user_id);
}
