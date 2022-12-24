package com.example.finalproject.entity;

import com.example.finalproject.request.AvailableRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "availability")
public class Available {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String time;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "model_id")
    private Model model;

    public Available(AvailableRequest availableRequest){
        city = availableRequest.getCity();
        time = availableRequest.getTime();
    }
}
