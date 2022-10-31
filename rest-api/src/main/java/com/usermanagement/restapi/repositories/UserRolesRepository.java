package com.usermanagement.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.restapi.models.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,Long> {
    
}
