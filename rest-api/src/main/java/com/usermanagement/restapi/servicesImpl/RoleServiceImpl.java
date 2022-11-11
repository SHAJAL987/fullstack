package com.usermanagement.restapi.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.usermanagement.restapi.exceptions.ResourceNotFoundException;
import com.usermanagement.restapi.models.Roles;
import com.usermanagement.restapi.payloads.RoleDto;
import com.usermanagement.restapi.repositories.FeatureRepository;
import com.usermanagement.restapi.repositories.RoleRepository;
import com.usermanagement.restapi.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository,FeatureRepository featureRepository) {
        this.roleRepository = roleRepository;
    }


    //Create Role Service ************** START ************** 
    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Roles roles = mapToEntity(roleDto);
        Roles newRoles = roleRepository.save(roles);
        RoleDto roleDtoResponse = mapToDto(newRoles);

        return roleDtoResponse;
    }

    private Roles mapToEntity(RoleDto roleDto){
        Roles roles = new Roles();
        roles.setRole_name(roleDto.getRole_name());
        roles.setRole_desc(roleDto.getRole_desc());
        roles.setRole_privilage(roleDto.getRole_privilage());
        roles.setStatus(roleDto.getStatus());
        roles.setCreate_by(roleDto.getCreate_by());
        roles.setFeatures(roleDto.getFeatures());

        return roles;
    }

    private RoleDto mapToDto(Roles roles){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(roles.getId());
        roleDto.setRole_name(roles.getRole_name());
        roleDto.setRole_name(roles.getRole_name());
        roleDto.setRole_desc(roles.getRole_desc());
        roleDto.setStatus(roles.getStatus());
        roleDto.setCreate_by(roles.getCreate_by());
        roleDto.setCreate_date(roles.getCreate_date());
        roleDto.setFeatures(roles.getFeatures());

        return roleDto;
    }


    //Get All Role Service **************** getAllRoles *****
    @Override
    public List<RoleDto> getAllRoles() {
        List<Roles> roles = roleRepository.findAll();
        return roles.stream().map(role->mapToDto(role)).collect(Collectors.toList());
    }

    //Get Role By Id Service ************ getRoleById *******
    @Override
    public RoleDto getRoleById(long id) {
        Roles roles = roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Roles", "id", id));
        return mapToDto(roles);
    }

    // Update Role By Id Service ****** updateRole **********
    @Override
    public RoleDto updateRole(RoleDto roleDto, long id) {
        Roles roles = roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Roles", "id", id));
        roles.setRole_name(roleDto.getRole_name());
        roles.setRole_desc(roleDto.getRole_desc());
        roles.setStatus(roleDto.getStatus());
        roles.setFeatures(roleDto.getFeatures());

        return mapToDto(roles);
    }

    // Delete Roles By Id Service ***** deleteRole *********
    @Override
    public void deleteRole(long id) {
        Roles roles = roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Roles", "id", id));
        roleRepository.delete(roles);
    }
    
}
