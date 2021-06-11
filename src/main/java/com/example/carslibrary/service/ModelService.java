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

    public List<ModelDTO> getModelByName(String modelName) throws Exception {
        if(modelName == null){
            throw new Exception("Name cannot be empty");
        }
        List<Model> modelsByName = modelRepository.getByName(modelName);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllFromModelYearMin(int year) throws Exception {
        if(year == 0){
            throw new Exception("Year cannot be empty");
        }
        List<Model> modelsByName = modelRepository.getAllByYearFromGreaterThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllFromModelYearMax(int year) throws Exception {
        if(year == 0){
            throw new Exception("Year cannot be empty");
        }
        List<Model> modelsByName = modelRepository.getAllByYearFromLessThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllToModelYearMin(int year) throws Exception {
        if(year == 0){
            throw new Exception("Year cannot be empty");
        }
        List<Model> modelsByName = modelRepository.getAllByYearToGreaterThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getAllToModelYearMax(int year) throws Exception {
        if(year == 0){
            throw new Exception("Year cannot be empty");
        }
        List<Model> modelsByName = modelRepository.getAllByYearToLessThanEqual(year);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }

    public List<ModelDTO> getModelsByMakeId(Long id) throws Exception {
        if(id == null){
            throw new Exception("Id cannot be empty");
        }
        List<Model> allModelsByMakeId = modelRepository.getAllByMakeId(id);
        List<ModelDTO> allModelsDTOSByMakeId = new ArrayList<>();
        if (allModelsByMakeId.size() == 0) {
            return new ArrayList<ModelDTO>();
        }
        allModelsByMakeId.forEach(model -> allModelsDTOSByMakeId.add(mapStructMapper.modelToModelDTO(model)));
        return allModelsDTOSByMakeId;
    }

    public List<ModelDTO> getModelsByYears(Long id, int yearFrom, int yearTo) throws Exception {
        if(yearFrom == 0 || yearTo == 0){
            throw new Exception("Year cannot be empty");
        }
        if(id == null){
            throw new Exception("Id cannot be empty");
        }

        List<Model> modelsByName = modelRepository.getAllByMakeIdAndYearFromGreaterThanEqualAndYearFromLessThanEqualOrYearToGreaterThanEqualAndYearToLessThanEqualAndMakeId((long) id,yearFrom,yearTo,yearFrom,yearTo, (long) id);
        List<ModelDTO> modelDTOs = new ArrayList<>();
        modelsByName.forEach(model -> modelDTOs.add(mapStructMapper.modelToModelDTO(model)));
        return modelDTOs;
    }
}
