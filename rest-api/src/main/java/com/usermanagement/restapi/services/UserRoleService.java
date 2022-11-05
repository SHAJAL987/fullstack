package com.usermanagement.restapi.services;

import com.usermanagement.restapi.payloads.UserRoleDto;

public interface UserRoleService {
    // Create User Service..... START ..........
    UserRoleDto createUserRole(UserRoleDto userRoleDto);
}
