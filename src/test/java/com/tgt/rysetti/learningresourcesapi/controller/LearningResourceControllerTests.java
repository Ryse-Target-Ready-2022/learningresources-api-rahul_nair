package com.tgt.rysetti.learningresourcesapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.rysetti.learningresourcesapi.service.LearningResourceService;
import com.tgt.rysetti.learningresourcesapi.controllers.LearningResourceController;
import com.tgt.rysetti.learningresourcesapi.entity.*;

@WebMvcTest(LearningResourceController.class)
public class LearningResourceControllerTests {
	
	
	    @MockBean
	    private LearningResourceService learningResourceService;
	    
	    @Autowired
	    ObjectMapper mapper;

	    @Autowired
	    private MockMvc mockMvc;
	
	@Test
    public void getAllTheAvailableLearningResources() throws Exception {
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResourceTestCase1 = new LearningResource(1001, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResourceTestCase2 = new LearningResource(1002, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResourceTestCase1);
        learningResources.add(learningResourceTestCase2);
        String expectedResponse = mapper.writeValueAsString(learningResources);

        when(learningResourceService.getLearningResources()).thenReturn(learningResources);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/learningresources/all"))
                                            .andExpect(status().isOk())
                                            .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
	
	 @Test
	    public void getTheRequestedResource() throws Exception {
	        int inputLearningResourceId = 1001;
	        Optional<LearningResource> learningResourceTestCase1 = Optional.ofNullable(new LearningResource(1002, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2)));
	        String expectedResponse = mapper.writeValueAsString(learningResourceTestCase1);
	        when(learningResourceService. getLearningResourceById(inputLearningResourceId)).thenReturn(learningResourceTestCase1);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/learningresources/" + inputLearningResourceId))
                    .andExpect(status().isOk())
                    .andReturn();
	        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
	    }
	 
	 
	
	@Test
    public void saveTheGivenLearningResources() throws Exception {
        List<LearningResource> inputLearningResources = new ArrayList<>();
        LearningResource learningResourceTestCase1 = new LearningResource(1001, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResourceTestCase2 = new LearningResource(1002, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        inputLearningResources.add(learningResourceTestCase1);
        inputLearningResources.add(learningResourceTestCase2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/learningresources/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(inputLearningResources)))
                    .andExpect(status().isCreated());
        
    }
	
	
	
	 @Test
	    public void deleteTheRequestedLearningResource() throws Exception {
	        int inputLearningResourceId = 1001;

	        this.mockMvc.perform(MockMvcRequestBuilders.delete("/learningresources/delete/" + inputLearningResourceId))
	                    .andExpect(status().isOk());
	    }
	
	
	

}
