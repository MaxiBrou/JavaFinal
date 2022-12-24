package com.example.finalproject.controller;

import com.example.finalproject.request.AvailableRequest;
import com.example.finalproject.response.AvailableResponse;
import com.example.finalproject.service.AvailableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/availability")
public class AvailableController {

    @Autowired
    private AvailableService availableService;

    @GetMapping("/{availableId}")
    public AvailableResponse getAvailability(@PathVariable long availableId){
        return new AvailableResponse(availableService.getAvailable(availableId));
    }

    @PutMapping("/{availableId}")
    public AvailableResponse updateAvailable(@PathVariable long availableId, @Valid @RequestBody AvailableRequest availableRequest){
        return new AvailableResponse(availableService.updateAvailable(availableId, availableRequest));
    }

    @DeleteMapping("/{availableId}")
    public void deleteAvailable(@PathVariable long availableId){
        availableService.deleteAvailable(availableId);
    }
}
