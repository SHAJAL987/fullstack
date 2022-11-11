package com.usermanagement.restapi.services;

import java.util.List;

import com.usermanagement.restapi.payloads.RoleDto;

public interface RoleService {
    // Create Role Service..... START ..........
    RoleDto createRole(RoleDto roleDto);

    // Get All Roles with Features ...... START .....
    List<RoleDto> getAllRoles();

    //Get All Roles By Id ............. START .........
    RoleDto getRoleById(long id);

    //Update Roles ............... START ............
    RoleDto updateRole(RoleDto roleDto, long id);

    //Delete Roles ................ START ...........
    void deleteRole(long id);
}
