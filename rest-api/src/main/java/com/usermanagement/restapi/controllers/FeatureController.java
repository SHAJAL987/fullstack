package com.usermanagement.restapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.restapi.payloads.FeatureDto;
import com.usermanagement.restapi.services.FeatureService;


@RestController
@RequestMapping("/user/f/v1.0")
public class FeatureController {
    private FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    // Create Feature --------- START ---------------->
    @PostMapping("/createFeature")
    public ResponseEntity<FeatureDto> createFeature(@Valid @RequestBody FeatureDto featureDto){
        return new ResponseEntity<>(featureService.createFeatures(featureDto),HttpStatus.CREATED);
    }

    //Get All Features START ------------------------>
    @GetMapping("/findAllFeatures")
    public List<FeatureDto> getAllFeatures(){
        return featureService.getAllFeatures();
    }

    //Update Feature START --------------------------->
    @PutMapping("/findFeatureById/{id}")
    public ResponseEntity<FeatureDto> updateFeatureById(@RequestBody FeatureDto featureDto,@PathVariable(name = "id") long id) {
        FeatureDto featureResponse = featureService.updateFeature(featureDto, id);
        return new ResponseEntity<>(featureResponse,HttpStatus.OK);
    }

    //Delete Feature By Id START --------------------->
    @DeleteMapping("/deleteFeature/{id}")
    public ResponseEntity<String> deleteFeatureById(@PathVariable(name = "id") long id ){
        return new ResponseEntity<>("Feature Updated Successfully",HttpStatus.OK);
    }
 
}
