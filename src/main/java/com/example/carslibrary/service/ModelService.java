package com.example.carslibrary.service;

import com.example.carslibrary.DTO.ModelDTO;
import com.example.carslibrary.entity.Model;
import com.example.carslibrary.repository.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    public ModelService(ModelMapper modelMapper, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    public ModelDTO getModelById(Long modelId) {
        Model allById = modelRepository.getAllById(modelId);
        if (allById == null) {
            return ModelDTO.builder().build();
        }
        return modelMapper.map(allById, ModelDTO.class);
    }

    public List<ModelDTO> getModelByName(String modelName) {
        List<Model> modelsByName = modelRepository.getByName(modelName);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(modelMapper.map(model, ModelDTO.class)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllFromModelYearMin(String year) {
        List<Model> modelsByName = modelRepository.getAllByYearFromGreaterThanEqual(Integer.parseInt(year));
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(modelMapper.map(model, ModelDTO.class)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllFromModelYearMax(String year) {
        List<Model> modelsByName = modelRepository.getAllByYearFromLessThanEqual(Integer.parseInt(year));
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(modelMapper.map(model, ModelDTO.class)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllToModelYearMin(String year) {
        List<Model> modelsByName = modelRepository.getAllByYearToGreaterThanEqual(Integer.parseInt(year));
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(modelMapper.map(model, ModelDTO.class)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllToModelYearMax(String year) {
        List<Model> modelsByName = modelRepository.getAllByYearToLessThanEqual(Integer.parseInt(year));
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(modelMapper.map(model, ModelDTO.class)));
        return modelDTOs;
    }

    public List<ModelDTO> getModelsByMakeId(Long id) {
        List<Model> allModelsByMakeId = modelRepository.getAllByMakeId(id);
        List<ModelDTO> allModelsDTOSByMakeId = new ArrayList<>();
        if (allModelsByMakeId.size() == 0) {
            return new ArrayList<ModelDTO>();
        }
        allModelsByMakeId.forEach(model -> allModelsDTOSByMakeId.add(modelMapper.map(model, ModelDTO.class)));
        return allModelsDTOSByMakeId;
    }
}
