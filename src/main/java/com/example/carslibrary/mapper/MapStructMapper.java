package com.example.carslibrary.mapper;

import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.DTO.ModelDTO;
import com.example.carslibrary.entity.Make;
import com.example.carslibrary.entity.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    ModelDTO modelToModelDTO(Model model);

    MakeDTO makeToMakeDTO(Make make);
}
