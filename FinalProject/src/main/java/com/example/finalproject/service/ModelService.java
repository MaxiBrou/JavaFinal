package com.example.finalproject.service;


import com.example.finalproject.entity.Available;
import com.example.finalproject.entity.Model;
import com.example.finalproject.exception.ResourceNotFound;
import com.example.finalproject.repository.AvailableRepository;
import com.example.finalproject.repository.ModelRepository;
import com.example.finalproject.request.AvailableRequest;
import com.example.finalproject.request.ModelRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    ModelRepository modelRepository;

    @Autowired
    AvailableRepository availableRepository;

    public Available addAvailabilityToModel(long modelId, AvailableRequest availableRequest){
        Model model = modelRepository.findById(modelId)
                .orElseThrow(()->new ResourceNotFound("Model not found"));
        Available availabilityToBeAdded = new Available(availableRequest);
        availabilityToBeAdded.setModel(model);
        return availableRepository.save(availabilityToBeAdded);
    }


    public List<Model> getAllModels(){
       return (List<Model>) modelRepository.findAll();
    }

    public Model insertModel(ModelRequest modelRequest){
        return modelRepository.save(new Model(modelRequest));
    }

    @PutMapping("/{id}")
    public Model updateModel(@PathVariable long id, @Valid @RequestBody ModelRequest modelRequest){
       return modelRepository.findById(id).map(model ->{
           Model modelToBeUpdated = new Model(modelRequest);
           modelToBeUpdated.setId(model.getId());
           return modelRepository.save(modelToBeUpdated);
       }).orElseThrow(()->new ResourceNotFound("Model id not found"));

    }

    public void deleteModel(long id){
        modelRepository.findById(id).orElseThrow(()->new ResourceNotFound("Model id not found"));
        modelRepository.deleteById(id);
    }


}
