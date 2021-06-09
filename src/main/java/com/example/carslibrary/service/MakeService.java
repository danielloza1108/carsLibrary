package com.example.carslibrary.service;

import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.entity.Make;
import com.example.carslibrary.repository.MakeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakeService {

    private final ModelMapper modelMapper;
    private final MakeRepository makeRepository;

    public MakeService(ModelMapper modelMapper, MakeRepository makeRepository) {
        this.modelMapper = modelMapper;
        this.makeRepository = makeRepository;
    }


    public List<MakeDTO> getAll() {
        List<Make> all = makeRepository.getAll();
        List<MakeDTO> allDTOS = new ArrayList<>();
        for (Make make : all) {
            allDTOS.add(modelMapper.map(make, MakeDTO.class));
        }
        return allDTOS;
    }

}
