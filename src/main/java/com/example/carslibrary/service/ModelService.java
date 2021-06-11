package com.example.carslibrary.service;

import com.example.carslibrary.DTO.ModelDTO;
import com.example.carslibrary.entity.Model;
import com.example.carslibrary.mapper.MapStructMapper;
import com.example.carslibrary.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    private final MapStructMapper mapStructMapper;
    private final ModelRepository modelRepository;

    public ModelService(MapStructMapper mapStructMapper, ModelRepository modelRepository) {
        this.mapStructMapper = mapStructMapper;
        this.modelRepository = modelRepository;
    }

    public ModelDTO getModelById(Long modelId) {
        Model allById = modelRepository.getAllById(modelId);
        if (allById == null) {
            return ModelDTO.builder().build();
        }
        return mapStructMapper.modelToModelDTO(allById);
    }

    public List<ModelDTO> getModelByName(String modelName) {
        List<Model> modelsByName = modelRepository.getByName(modelName);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllFromModelYearMin(int year) {
        List<Model> modelsByName = modelRepository.getAllByYearFromGreaterThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllFromModelYearMax(int year) {
        List<Model> modelsByName = modelRepository.getAllByYearFromLessThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllToModelYearMin(int year) {
        List<Model> modelsByName = modelRepository.getAllByYearToGreaterThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllToModelYearMax(int year) {
        List<Model> modelsByName = modelRepository.getAllByYearToLessThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getModelsByMakeId(Long id) {
        List<Model> allModelsByMakeId = modelRepository.getAllByMakeId(id);
        List<ModelDTO> allModelsDTOSByMakeId = new ArrayList<>();
        if (allModelsByMakeId.size() == 0) {
            return new ArrayList<ModelDTO>();
        }
        allModelsByMakeId.forEach(model -> allModelsDTOSByMakeId.add(mapStructMapper.modelToModelDTO(model)));
        return allModelsDTOSByMakeId;
    }

    public List<ModelDTO> getModelsByYears(int id, int yearFrom, int yearTo){
        List<Model> modelsByName = modelRepository.getAllByMakeIdAndYearFromGreaterThanEqualAndYearFromLessThanEqualOrYearToGreaterThanEqualAndYearToLessThanEqual((long) id,yearFrom,yearTo,yearFrom,yearTo);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }
}
