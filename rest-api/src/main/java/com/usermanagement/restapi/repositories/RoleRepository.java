package com.usermanagement.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.restapi.models.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long>{
    
}
