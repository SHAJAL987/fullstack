package com.usermanagement.restapi.services;

import java.util.List;

import com.usermanagement.restapi.payloads.FeatureDto;

public interface FeatureService {
    // Create Feature Service..... START ..........
    FeatureDto createFeatures(FeatureDto features);

    //Get All Feature Service .... START .........
    List<FeatureDto> getAllFeatures();

    //Get All Feature By Id ..... START .........
    FeatureDto getFeatureById(long id);

    //Update Feature ............. START ........
    FeatureDto updateFeature(FeatureDto featureDto, long id);

    //Delete Feature .......... START ...............
    void deleteFeatureById(long id);
}
