package com.example.carslibrary.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO {
    private Long id;
    private String name;
    private int yearFrom;
    private int yearTo;
}
