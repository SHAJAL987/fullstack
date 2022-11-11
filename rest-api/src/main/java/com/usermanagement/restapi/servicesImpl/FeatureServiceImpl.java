package com.usermanagement.restapi.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.usermanagement.restapi.exceptions.ResourceNotFoundException;
import com.usermanagement.restapi.models.Features;
import com.usermanagement.restapi.payloads.FeatureDto;
import com.usermanagement.restapi.repositories.FeatureRepository;
import com.usermanagement.restapi.services.FeatureService;

@Service
public class FeatureServiceImpl implements FeatureService{

    private FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    //Create Feature Service ************** createFeatures ****************
    @Override
    public FeatureDto createFeatures(FeatureDto featureDto) {

        Features features = mapToEntity(featureDto);
        Features newFeatures = featureRepository.save(features); 
        return mapToDto(newFeatures);
    }

    private Features mapToEntity(FeatureDto featureDto){
        Features features = new Features();
        features.setFeature_name(featureDto.getFeature_name());
        features.setParent_feature(featureDto.getParent_feature());
        features.setChiled_or_parent(featureDto.getChiled_or_parent());
        features.setLevel(featureDto.getLevel());
        features.setEnd_point(featureDto.getEnd_point());
        features.setStatus(featureDto.getStatus());
        features.setCreate_by(featureDto.getCreate_by());

        return features;
    }

    private FeatureDto mapToDto(Features features){
        FeatureDto responseFeatureDto = new FeatureDto();
        responseFeatureDto.setId(features.getId());
        responseFeatureDto.setFeature_name(features.getFeature_name());
        responseFeatureDto.setParent_feature(features.getParent_feature());
        responseFeatureDto.setChiled_or_parent(features.getChiled_or_parent());
        responseFeatureDto.setLevel(features.getLevel());
        responseFeatureDto.setEnd_point(features.getEnd_point());
        responseFeatureDto.setStatus(features.getStatus());
        responseFeatureDto.setCreate_by(features.getCreate_by());
        responseFeatureDto.setCreate_date(features.getCreate_date());
        responseFeatureDto.setRes_code("100");
        responseFeatureDto.setRes_message("Operation Successfull.");

        return responseFeatureDto;
    }

    //Get All Features Service ********* getAllFeatures ***********
    @Override
    public List<FeatureDto> getAllFeatures() {
        List<Features> features = featureRepository.findAll();
        return features.stream().map(feature-> mapToDto(feature)).collect(Collectors.toList());
    }

    //Get Feature By Id Service ********** getFeatureById **********
    @Override
    public FeatureDto getFeatureById(long id) {
        Features features = featureRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Feature Update","Feature id", id));
        return mapToDto(features);
    }

    //Get Feature Update By Id *********** updateFeature ***********
    @Override
    public FeatureDto updateFeature(FeatureDto featureDto, long id) {
        Features features = featureRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Feature Update","Feature id", id));

        features.setFeature_name(featureDto.getFeature_name());
        features.setParent_feature(featureDto.getParent_feature());
        features.setChiled_or_parent(featureDto.getChiled_or_parent());
        features.setLevel(featureDto.getLevel());
        features.setEnd_point(featureDto.getEnd_point());
        features.setStatus(featureDto.getStatus());
        
        return mapToDto(features);
    }

    // Delete Feature By Id Serivce ************ deleteFeatureById *********
    @Override
    public void deleteFeatureById(long id) {
        Features features = featureRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Feature Delete","Feature id", id));
        featureRepository.delete(features);
    }

    
}
