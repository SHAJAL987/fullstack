package com.usermanagement.restapi.servicesImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.usermanagement.restapi.exceptions.ResourceNotFoundException;
import com.usermanagement.restapi.models.Users;
import com.usermanagement.restapi.payloads.UserCreationDto;
import com.usermanagement.restapi.repositories.UsersRepository;
import com.usermanagement.restapi.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    //Create User Service ************** START ************** 
    @Override
    public UserCreationDto createUser(UserCreationDto userCreationDto) {
        Users usersObj = mapToEntity(userCreationDto);
        Users newUsersObj = usersRepository.save(usersObj);
        UserCreationDto userCreationDtoObj = mapToDto(newUsersObj);

        return userCreationDtoObj;
    }
    
    private Users mapToEntity(UserCreationDto userCreationDto){
        Users users = new Users();
        users.setUser_code(userCreationDto.getUser_code());
        users.setUser_name(userCreationDto.getUser_name());
        users.setPassword(userCreationDto.getPassword());
        users.setMobile(userCreationDto.getMobile());
        users.setStatus(userCreationDto.getStatus());
        users.setCreate_by(userCreationDto.getCreate_by());

        return users;
    }

    private UserCreationDto mapToDto(Users users){
        UserCreationDto userCreationDto = new UserCreationDto();
        userCreationDto.setUser_id(users.getUser_id());
        userCreationDto.setUser_code(users.getUser_code());
        userCreationDto.setUser_name(users.getUser_name());
        userCreationDto.setMobile(users.getMobile());
        userCreationDto.setStatus(users.getStatus());
        userCreationDto.setCreate_by(users.getCreate_by());
        userCreationDto.setCreate_date(users.getCreate_date());
        userCreationDto.setPassword("*****");

        return userCreationDto;
    }

    //Get All User Service *************  START ************** 
    @Override
    public List<UserCreationDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(user -> mapToDto(user) ).collect(Collectors.toList());
    }

    //Get User By Id Service *********** START  **************
    @Override
    public UserCreationDto getUserById(long user_id) {
        Users users = usersRepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user_id", user_id));
        return mapToDto(users);
    } 
    
}
