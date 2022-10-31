package com.usermanagement.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.restapi.models.Features;

@Repository
public interface FeatureRepository extends JpaRepository<Features,Long>{
    
}
