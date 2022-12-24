package com.example.finalproject.entity;


import com.example.finalproject.request.AddressRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="addresses")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="postal_code")
    private String postalCode;

    public Address(AddressRequest addressRequest){
        street = addressRequest.getStreet();
        city = addressRequest.getCity();
        postalCode = addressRequest.getPostalCode();
    }
}

