package com.example.carslibrary.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModelDTO {
    private String name;
    private int year_from;
    private int year_to;
}
