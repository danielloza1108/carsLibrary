package com.example.carslibrary.controller;

import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.DTO.ModelDTO;
import com.example.carslibrary.service.MakeService;
import com.example.carslibrary.service.ModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final MakeService makeService;
    private final ModelService modelService;

    public MainController(MakeService makeService, ModelService modelService) {
        this.makeService = makeService;
        this.modelService = modelService;
    }
    //Endpoint wyszukujący wszystkie marki samochodów w bazie.
    @GetMapping( "/allMake")
    public List<MakeDTO> getAllMakes(){
        return makeService.getAll();
    }

    //Endpoint wyszukujący wszystkie modele samochodów dla podanej marki samochodu.
    @GetMapping("/idMake/{idMake}")
    public List<ModelDTO> getByIdMake(@PathVariable String idMake) throws Exception {
        List<ModelDTO> modelsByMakeId = modelService.getModelsByMakeId(Long.valueOf(idMake));
        if(modelsByMakeId.size() == 0){
            throw new Exception("Not in database!");
        }
        return modelsByMakeId;
    }

    @GetMapping("/idModel/{idModel}")
    public ModelDTO getByIdModel(@PathVariable String idModel) throws Exception {
        ModelDTO modelById = modelService.getModelById(Long.valueOf(idModel));
        if(modelById.getName() == null){
            throw new Exception("Not in database!");
        }
        return modelById;
    }

    @GetMapping("/model/{modelName}")
    public List<ModelDTO> getAllByModelName(@PathVariable String modelName) throws Exception {
        List<ModelDTO> modelsByName = modelService.getModelByName(modelName);
        return modelsByName;
    }

    @GetMapping("/modelYearFromMin/{year}")
    public List<ModelDTO> getAllFromModelYearMin(@PathVariable String year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllFromModelYearMin(year);
        return modelsByName;
    }

    @GetMapping("/modelYearFromMax/{year}")
    public List<ModelDTO> getAllFromModelYearMax(@PathVariable String year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllFromModelYearMax(year);
        return modelsByName;
    }

    @GetMapping("/modelYearToMin/{year}")
    public List<ModelDTO> getAllToModelYearMin(@PathVariable String year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllToModelYearMin(year);
        return modelsByName;
    }

    @GetMapping("/modelYearToMax/{year}")
    public List<ModelDTO> getAllToModelYearMax(@PathVariable String year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllToModelYearMax(year);
        return modelsByName;
    }
}
