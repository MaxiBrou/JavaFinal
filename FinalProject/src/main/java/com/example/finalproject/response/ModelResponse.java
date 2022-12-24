package com.example.finalproject.response;

import com.example.finalproject.entity.Address;
import com.example.finalproject.entity.Model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String instagram;
    private String email;
    private AddressResponse address;

    public ModelResponse(Model model){
        id = model.getId();
        firstName = model.getFirstName();
        lastName = model.getLastName();
        instagram = model.getInstagram();
        email = model.getEmail();
        address = new AddressResponse(model.getAddress());


    }
}
