package com.example.carslibrary.controller;

import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.DTO.ModelDTO;
import com.example.carslibrary.service.MakeService;
import com.example.carslibrary.service.ModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car-management")
public class MainController {
    private final MakeService makeService;
    private final ModelService modelService;

    public MainController(MakeService makeService, ModelService modelService) {
        this.makeService = makeService;
        this.modelService = modelService;
    }
    //Endpoint wyszukujący wszystkie marki samochodów w bazie.
    @GetMapping( "/makes")
    public List<MakeDTO> getAllMakes(){
        return makeService.getAll();
    }

    //Endpoint wyszukujący wszystkie modele samochodów dla podanej marki samochodu.
    @GetMapping("/makes/{idMake}")
    public List<ModelDTO> getByIdMake(@PathVariable String idMake) throws Exception {
        List<ModelDTO> modelsByMakeId = modelService.getModelsByMakeId(Long.valueOf(idMake));
        if(modelsByMakeId.size() == 0){
            throw new Exception("Not in database!");
        }
        return modelsByMakeId;
    }

    @GetMapping("/models/id/{idModel}")
    public ModelDTO getByIdModel(@PathVariable String idModel) throws Exception {
        ModelDTO modelById = modelService.getModelById(Long.valueOf(idModel));
        if(modelById.getName() == null){
            throw new Exception("Not in database!");
        }
        return modelById;
    }

    @GetMapping("/models/name/{modelName}")
    public List<ModelDTO> getAllByModelName(@PathVariable String modelName) throws Exception {
        List<ModelDTO> modelsByName = modelService.getModelByName(modelName);
        return modelsByName;
    }

    @GetMapping("/models/min/from/{year}")
    public List<ModelDTO> getAllFromModelYearMin(@PathVariable int year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllFromModelYearMin(year);
        return modelsByName;
    }

    @GetMapping("/models/max/from/{year}")
    public List<ModelDTO> getAllFromModelYearMax(@PathVariable int year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllFromModelYearMax(year);
        return modelsByName;
    }

    @GetMapping("/models/min/to/{year}")
    public List<ModelDTO> getAllToModelYearMin(@PathVariable int year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllToModelYearMin(year);
        return modelsByName;
    }

    @GetMapping("/models/max/to/{year}")
    public List<ModelDTO> getAllToModelYearMax(@PathVariable int year) throws Exception {
        List<ModelDTO> modelsByName = modelService.getAllToModelYearMax(year);
        return modelsByName;
    }
}
