package com.usermanagement.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.restapi.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long>{
    
}
