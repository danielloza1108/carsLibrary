package com.example.carslibrary.service;

import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.entity.Make;
import com.example.carslibrary.mapper.MapStructMapper;
import com.example.carslibrary.repository.MakeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakeService {

    private final MapStructMapper mapStructMapper;
    private final MakeRepository makeRepository;

    public MakeService(MapStructMapper mapStructMapper, MakeRepository makeRepository) {
        this.mapStructMapper = mapStructMapper;
        this.makeRepository = makeRepository;
    }


    public List<MakeDTO> getAll() {
        List<Make> all = makeRepository.getAll();
        List<MakeDTO> allDTOs = new ArrayList<>();
        all.forEach(make -> allDTOs.add(mapStructMapper.makeToMakeDTO(make)));
        return allDTOs;
    }

}
