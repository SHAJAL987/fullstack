package com.usermanagement.restapi.services;

import com.usermanagement.restapi.models.Roles;
import com.usermanagement.restapi.payloads.RoleDto;

public interface RoleService {
    // Create Role Service..... START ..........
    RoleDto createRole(RoleDto roleDto);

    Roles creatRoles(Roles roles);
}
