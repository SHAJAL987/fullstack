package com.usermanagement.restapi.servicesImpl;


import org.springframework.stereotype.Service;

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


    // Create User Service Implimentation..... START ..........
    @Override
    public UserCreationDto createUser(UserCreationDto userCreationDto) {

        //convert DTO to entity
        Users usersObj = mapToEntity(userCreationDto);
        Users newUsersObj = usersRepository.save(usersObj);

        //convert Entity to DTO
        UserCreationDto userCreationDtoObj = mapToDto(newUsersObj);

        return userCreationDtoObj;
    }
    // Create User Service Implimentation..... END .............

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

        return userCreationDto;
    }



    
    
}
