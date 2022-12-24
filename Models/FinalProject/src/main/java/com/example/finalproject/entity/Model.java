package com.example.finalproject.entity;

import com.example.finalproject.request.AddressRequest;
import com.example.finalproject.request.ModelRequest;
import com.example.finalproject.response.AddressResponse;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "models")
public class Model {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "first_name", nullable = false)
        private String firstName;
        @Column(name = "last_name", nullable = false)
        private String lastName;
        @Column(name = "instagram", nullable = false)
        private String instagram;
        @Column(name = "email", nullable = false)
        private String email;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name ="address")
        private Address address;


        public Model(ModelRequest modelRequest){
                firstName = modelRequest.getFirstName();
                lastName = modelRequest.getLastName();
                instagram = modelRequest.getInstagram();
                email = modelRequest.getEmail();

                address = new Address(modelRequest.getAddress());


        }




}
