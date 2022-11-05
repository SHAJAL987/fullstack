package com.usermanagement.restapi.servicesImpl;

import org.springframework.stereotype.Service;

import com.usermanagement.restapi.exceptions.ResourceNotFoundException;
import com.usermanagement.restapi.models.UserRoles;
import com.usermanagement.restapi.models.Users;
import com.usermanagement.restapi.payloads.UserRoleDto;
import com.usermanagement.restapi.repositories.UserRepository;
import com.usermanagement.restapi.repositories.UserRolesRepository;
import com.usermanagement.restapi.services.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    private UserRepository userRepository;
    private UserRolesRepository userRolesRepository;

    
    public UserRoleServiceImpl(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }


    @Override
    public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
        Users users = userRepository.findById(userRoleDto.getUser_id_pk()).orElseThrow(()->new ResourceNotFoundException("User Roles", "user_id_pk", userRoleDto.getUser_id_pk()));
        UserRoles roles = userRolesRepository.findById(userRoleDto.getRole_id_pk()).orElseThrow(()->new ResourceNotFoundException("Roles", "role_id_pk", userRoleDto.getRole_id_pk()));

        System.out.println(users+"-"+roles);

        UserRoles userRoles = mapToEntity(userRoleDto);
        UserRoles newUserRoles = userRolesRepository.save(userRoles);
        UserRoleDto userRoleDtoObj = mapToDto(newUserRoles);

        return userRoleDtoObj;
    }

    private UserRoles mapToEntity(UserRoleDto userRoleDto){
        UserRoles userRoles = new UserRoles();
        userRoles.setUser_id(userRoleDto.getUser_id_pk());
        userRoles.setRole_id(userRoleDto.getRole_id_pk());
        userRoles.setStatus(userRoleDto.getStatus());
        userRoles.setCreate_by(userRoleDto.getCreate_by());

        return userRoles;
    }

    private UserRoleDto mapToDto(UserRoles userRoles){
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setId(userRoles.getId());
        userRoleDto.setUser_id_pk(userRoles.getUser_id());
        userRoleDto.setRole_id_pk(userRoleDto.getRole_id_pk());
        userRoleDto.setStatus(userRoles.getStatus());
        userRoleDto.setCreate_by(userRoleDto.getCreate_by());
        userRoleDto.setCreate_date(userRoles.getCreate_date());
        userRoleDto.setResCode("201");
        userRoleDto.setResMessage("Operation Successfull");

        return userRoleDto;
    }
    
}
