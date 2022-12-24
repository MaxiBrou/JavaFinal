package com.example.finalproject.response;

import com.example.finalproject.entity.Available;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableResponse {
    private long id;

    private String city;

    private String time;

    private ModelResponse model;

    public AvailableResponse(Available available){
        id = available.getId();
        city = available.getCity();
        time = available.getTime();
        model = new ModelResponse(available.getModel());
    }
}
