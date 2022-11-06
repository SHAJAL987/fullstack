package com.usermanagement.restapi.services;

import java.util.List;

import com.usermanagement.restapi.payloads.UserRoleDto;

public interface UserRoleService {
    // Create User Service..... START ..........
    UserRoleDto createUserRole(UserRoleDto userRoleDto);

    // Get All Users Role Service..... START ..........
    List<UserRoleDto> getAllUserRoles();

    // Get User Role By Id Service..... START ..........
    UserRoleDto getUserRoleById(long id);

    //Update User Role .......... START ................
    UserRoleDto updateUserRole(UserRoleDto userRoleDto, long id);

    //Delete User Role .......... START ...............
    void deleteUserRoleById(long id);
}
