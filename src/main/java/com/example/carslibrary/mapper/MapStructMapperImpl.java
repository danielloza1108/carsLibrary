package com.example.carslibrary.mapper;

import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.DTO.ModelDTO;
import com.example.carslibrary.entity.Make;
import com.example.carslibrary.entity.Model;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public ModelDTO modelToModelDTO(Model model) {
        if (model == null) {
            return null;
        }
        ModelDTO modelDTO = ModelDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .yearFrom(model.getYearFrom())
                .yearTo(model.getYearTo())
                .build();
        return modelDTO;
    }

    @Override
    public MakeDTO makeToMakeDTO(Make make) {
        if (make == null) {
            return null;
        }
        MakeDTO makeDTO = new MakeDTO();
        makeDTO.setName(make.getName());
        makeDTO.setId(make.getId());
        return makeDTO;
    }
}
