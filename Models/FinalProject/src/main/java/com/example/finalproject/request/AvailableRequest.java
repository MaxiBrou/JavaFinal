package com.example.finalproject.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableRequest {
    @NotBlank
    private String city;
    @NotBlank
    private String time;
}
