package com.example.carslibrary.controller;


import com.example.carslibrary.DTO.MakeDTO;
import com.example.carslibrary.DTO.ModelDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest
@RunWith(SpringRunner.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainController mainController;


    private List<MakeDTO> getMakeDTO() {
        MakeDTO makeDTO = new MakeDTO();
        makeDTO.setId(1L);
        makeDTO.setName("SKODA");
        MakeDTO makeDTO2 = new MakeDTO();
        makeDTO2.setId(2L);
        makeDTO2.setName("BMW");
        MakeDTO makeDTO3 = new MakeDTO();
        makeDTO3.setId(3L);
        makeDTO3.setName("AUDI");
        List<MakeDTO> makeDTOS = new ArrayList<>();
        makeDTOS.add(makeDTO);
        makeDTOS.add(makeDTO2);
        makeDTOS.add(makeDTO3);

        return makeDTOS;
    }

    private List<ModelDTO> getModelDTOS() {
        ModelDTO modelDTO = ModelDTO.builder()
                .name("FABIA")
                .yearFrom(2012)
                .yearTo(2022)
                .build();
        ModelDTO modelDTO2 = ModelDTO.builder()
                .name("KODIAQ")
                .yearFrom(2012)
                .yearTo(2022)
                .build();
        ModelDTO modelDTO3 = ModelDTO.builder()
                .name("YETI")
                .yearFrom(2012)
                .yearTo(2022)
                .build();
        List<ModelDTO> modelDTOS = new ArrayList<>();
        modelDTOS.add(modelDTO);
        modelDTOS.add(modelDTO2);
        modelDTOS.add(modelDTO3);

        return modelDTOS;
    }

    private List<ModelDTO> getModelsByName() {
        ModelDTO modelDTO = ModelDTO.builder()
                .name("FABIA")
                .yearFrom(2012)
                .yearTo(2022)
                .build();
        ModelDTO modelDTO2 = ModelDTO.builder()
                .name("FLUENCE")
                .yearFrom(2012)
                .yearTo(2022)
                .build();
        ModelDTO modelDTO3 = ModelDTO.builder()
                .name("FJ")
                .yearFrom(2012)
                .yearTo(2022)
                .build();
        List<ModelDTO> modelDTOS = new ArrayList<>();
        modelDTOS.add(modelDTO);
        modelDTOS.add(modelDTO2);
        modelDTOS.add(modelDTO3);

        return modelDTOS;
    }

    @Test
    public void getAllMakes() throws Exception {
        given(mainController.getAllMakes()).willReturn(getMakeDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/makes")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }


    @Test
    public void getByIdMake() throws Exception {
        given(mainController.getByIdMake(1L)).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/makes/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getByIdModel() throws Exception {
        ModelDTO modelDTO = ModelDTO.builder()
                .name("FABIA")
                .yearFrom(2012)
                .yearTo(2022)
                .build();

        given(mainController.getByIdModel(1L)).willReturn(modelDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/models/id/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.yearFrom").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.yearTo").exists());
    }

    @Test
    public void getAllByModelName() throws Exception {
        given(mainController.getAllByModelName("F")).willReturn(getModelsByName());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/models/name/F")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
        ;

    }

    @Test
    public void getAllFromModelYearMin() throws Exception {
        given(mainController.getAllFromModelYearMin(2012)).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/models/min/from/2012")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getAllFromModelYearMax() throws Exception {
        given(mainController.getAllFromModelYearMax(2022)).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/models/max/from/2022")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getAllToModelYearMin() throws Exception {
        given(mainController.getAllToModelYearMin(2000)).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/models/min/to/2000")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    public void getAllToModelYearMax() throws Exception {
        given(mainController.getAllToModelYearMax(2008)).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/car-management/models/max/to/2008")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}