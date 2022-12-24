package com.example.finalproject.controller;


import com.example.finalproject.entity.Model;
import com.example.finalproject.request.AvailableRequest;
import com.example.finalproject.request.ModelRequest;
import com.example.finalproject.response.AvailableResponse;
import com.example.finalproject.response.ModelResponse;
import com.example.finalproject.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/models")
public class ModelController {
    @Autowired
    ModelService modelService;

    @GetMapping()
    public List<ModelResponse> getAllModels(){
       List<Model> models = modelService.getAllModels();

        List<ModelResponse> modelsResponse = new ArrayList<>();
        models.forEach(model ->{
            modelsResponse.add(new ModelResponse(model));
        });

        return modelsResponse;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ModelResponse addTeacher(@Valid @RequestBody ModelRequest modelRequest){
        Model model = modelService.insertModel(modelRequest);
        return new ModelResponse(model);
    }
    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable long id){
        modelService.deleteModel(id);
    }

    @PostMapping("/{modelId}/availability")
    public AvailableResponse addAvailability(
            @PathVariable long modelId,
            @Valid @RequestBody AvailableRequest availableRequest)
    {
        return new AvailableResponse(
                    modelService.addAvailabilityToModel(modelId, availableRequest));
    }
}
