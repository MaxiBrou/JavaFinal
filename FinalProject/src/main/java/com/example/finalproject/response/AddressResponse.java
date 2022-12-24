package com.example.finalproject.response;

import com.example.finalproject.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private String street;

    private String city;
    private String postalCode;

    public AddressResponse(Address address)
    {
        street = address.getStreet();
        city = address.getCity();
        postalCode = address.getPostalCode();
    }
}
