package com.example.finalproject.service;

import com.example.finalproject.entity.Available;
import com.example.finalproject.exception.ResourceNotFound;
import com.example.finalproject.repository.AvailableRepository;
import com.example.finalproject.request.AvailableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class AvailableService {
    @Autowired
    private AvailableRepository availableRepository;

    public Available getAvailable(long availableId){
        Available available = availableRepository.findById(availableId).orElseThrow(()->new ResourceNotFound("Availability id not found"));
        return available;
    }

    public Available updateAvailable(long availableId, AvailableRequest availableRequest){
       if( availableRepository.existsById(availableId)){
           Available availabilityToBeUpdated = new Available(availableRequest);
           availabilityToBeUpdated.setId(availableId);
           return availableRepository.save(availabilityToBeUpdated);

       }
       else{
           throw new ResourceNotFound("Availability id not found");
       }
    }

    public void deleteAvailable(long availableId){
        if(availableRepository.existsById(availableId)){
            availableRepository.deleteById(availableId);
        }
        else{
            throw new ResourceNotFound("Availability id not found");
        }
    }
}
