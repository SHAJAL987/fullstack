package com.usermanagement.restapi.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.usermanagement.restapi.exceptions.ResourceNotFoundException;
import com.usermanagement.restapi.models.Roles;
import com.usermanagement.restapi.models.UserRoles;
import com.usermanagement.restapi.models.Users;
import com.usermanagement.restapi.payloads.UserRoleDto;
import com.usermanagement.restapi.repositories.RoleRepository;
import com.usermanagement.restapi.repositories.UserRepository;
import com.usermanagement.restapi.repositories.UserRolesRepository;
import com.usermanagement.restapi.services.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    private UserRepository userRepository;
    private UserRolesRepository userRolesRepository;
    private RoleRepository roleRepository;

    
    public UserRoleServiceImpl(UserRepository userRepository, UserRolesRepository userRolesRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.roleRepository = roleRepository;
    }


    //Create User Role Service ************** START ************** 
    @Override
    public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
        Users users = userRepository.findById(userRoleDto.getUser_id_pk()).orElseThrow(()->new ResourceNotFoundException("User Roles", "user_id_pk", userRoleDto.getUser_id_pk()));
        Roles roles = roleRepository.findById(userRoleDto.getRole_id_pk()).orElseThrow(()->new ResourceNotFoundException("Roles", "role_id_pk", userRoleDto.getRole_id_pk()));

        System.out.println(users.getUser_code()+"-"+roles.getRole_name());

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
        userRoleDto.setRole_id_pk(userRoles.getRole_id());
        userRoleDto.setStatus(userRoles.getStatus());
        userRoleDto.setCreate_by(userRoles.getCreate_by());
        userRoleDto.setCreate_date(userRoles.getCreate_date());
        userRoleDto.setResCode("100");
        userRoleDto.setResMessage("Operation Successfull.");

        return userRoleDto;
    }


    //Get All User Roles Service *************  getAllUserRoles  ************** 
    @Override
    public List<UserRoleDto> getAllUserRoles() {
        List<UserRoles> userRoles = userRolesRepository.findAll();
        return userRoles.stream().map(userRole ->mapToDto(userRole) ).collect(Collectors.toList());
    }

    //Get User Roles By Id Service *********** getUserRolesById  **************
    @Override
    public UserRoleDto getUserRoleById(long id) {
        UserRoles users = userRolesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Role", "id", id));
        return mapToDto(users);
    }


    //Update User Role By Id Service *********** updateUserRole  **************
    @Override
    public UserRoleDto updateUserRole(UserRoleDto userRoleDto, long id) {
        UserRoles userRoles = userRolesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Role", "id", id));
        userRoles.setUser_id(userRoleDto.getUser_id_pk());
        userRoles.setRole_id(userRoleDto.getRole_id_pk());
        userRoles.setStatus(userRoleDto.getStatus());
        
        return mapToDto(userRoles);
    }


    //Update User By Id Service *********** deleteUserById  **************
    @Override
    public void deleteUserRoleById(long id) {
        UserRoles userRoles = userRolesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Role", "id", id));
        userRolesRepository.delete(userRoles);
    }

    
    
}
