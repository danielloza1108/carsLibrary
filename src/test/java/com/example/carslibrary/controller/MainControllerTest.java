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
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setYear_to(2022);
        modelDTO.setYear_from(2012);
        modelDTO.setName("FABIA");
        ModelDTO modelDTO2 = new ModelDTO();
        modelDTO2.setYear_to(2022);
        modelDTO2.setYear_from(2012);
        modelDTO2.setName("KODIAQ");
        ModelDTO modelDTO3 = new ModelDTO();
        modelDTO3.setYear_to(2022);
        modelDTO3.setYear_from(2012);
        modelDTO3.setName("YETI");
        List<ModelDTO> modelDTOS = new ArrayList<>();
        modelDTOS.add(modelDTO);
        modelDTOS.add(modelDTO2);
        modelDTOS.add(modelDTO3);

        return modelDTOS;
    }

    private List<ModelDTO> getModelsByName() {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setYear_to(2022);
        modelDTO.setYear_from(2012);
        modelDTO.setName("FABIA");
        ModelDTO modelDTO2 = new ModelDTO();
        modelDTO2.setYear_to(2022);
        modelDTO2.setYear_from(2012);
        modelDTO2.setName("FLUENCE");
        ModelDTO modelDTO3 = new ModelDTO();
        modelDTO3.setYear_to(2022);
        modelDTO3.setYear_from(2012);
        modelDTO3.setName("FJ");
        List<ModelDTO> modelDTOS = new ArrayList<>();
        modelDTOS.add(modelDTO);
        modelDTOS.add(modelDTO2);
        modelDTOS.add(modelDTO3);

        return modelDTOS;
    }

    @Test
    public void getAllMakes() throws Exception {
        given(mainController.getAllMakes()).willReturn(getMakeDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/allMake")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }


    @Test
    public void getByIdMake() throws Exception {
        given(mainController.getByIdMake("1")).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/idMake/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getByIdModel() throws Exception {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setName("FABIA");
        modelDTO.setYear_from(2012);
        modelDTO.setYear_to(2022);

        given(mainController.getByIdModel("1")).willReturn(modelDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/idModel/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.year_from").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.year_to").exists());
    }

    @Test
    public void getAllByModelName() throws Exception {
        given(mainController.getAllByModelName("F")).willReturn(getModelsByName());

        mockMvc.perform(MockMvcRequestBuilders.get("/model/F")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));;

    }

    @Test
    public void getAllFromModelYearMin() throws Exception {
        given(mainController.getAllFromModelYearMin("2012")).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/modelYearFromMin/2012")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getAllFromModelYearMax() throws Exception {
        given(mainController.getAllFromModelYearMax("2022")).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/modelYearFromMax/2022")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getAllToModelYearMin() throws Exception {
        given(mainController.getAllToModelYearMin("2000")).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/modelYearToMin/2000")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    public void getAllToModelYearMax() throws Exception {
        given(mainController.getAllToModelYearMax("2008")).willReturn(getModelDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/modelYearToMax/2008")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}