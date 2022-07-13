package com.tgt.rysetti.learningresourcesapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetti.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetti.learningresourcesapi.repository.LearningResourceRepository;

@ExtendWith(MockitoExtension.class)
public class LearningResourceServiceTests {

	@Mock
    LearningResourceRepository learningResourceRepository;
	
	@InjectMocks
	LearningResourceService learningResourceService;
	
	
	
	 @Test
	    public void sortTheLearningResourceBasedOnProfitMarginInNonIncreasingOrder(){
	        List<LearningResource> learningResources = new ArrayList<>();
	        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 150.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(2), LocalDate.now().plusYears(4));
	        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 100.0, 200.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(3), LocalDate.now().plusYears(5));
	        learningResources.add(learningResource1);
	        learningResources.add(learningResource2);

	        learningResources.sort((lr1, lr2) -> {
	            Double profitMargin1 = (lr1.getSellingPrice() - lr1.getCostPrice())/lr1.getSellingPrice();
	            Double profitMargin2 = (lr2.getSellingPrice() - lr2.getCostPrice())/lr2.getSellingPrice();

	            return profitMargin2.compareTo(profitMargin1) ;
	        });
	        when(learningResourceRepository.findAll()).thenReturn(learningResources);

	        TreeMap<Double,LearningResource> learningResourcesSorted = learningResourceService.sortedLearningResourceByProfitMargin();
	        ArrayList<LearningResource> sortedLearningResourcesList
	        = new ArrayList<LearningResource>(learningResourcesSorted.values());
	    
	        assertEquals(learningResources, sortedLearningResourcesList, "The learning resources are not sorted by profit margin");
	    }
	
	@Test
    public void saveTheLearningResources(){
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResourceTestCase1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResourceTestCase2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.RETIRED, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        LearningResource learningResourceTestCase3 = new LearningResource(1313, "Test Name 3", 120.0, 180.0, LearningResourceStatus.PLANNING, LocalDate.now(), LocalDate.now().plusMonths(7), LocalDate.now().plusYears(4));
        LearningResource learningResourceTestCase4 = new LearningResource(1313, "Test Name 3", 120.0, 180.0, LearningResourceStatus.PUBLISHED, LocalDate.now(), LocalDate.now().plusMonths(8), LocalDate.now().plusYears(5));
        learningResources.add(learningResourceTestCase1);
        learningResources.add(learningResourceTestCase2);
        learningResources.add(learningResourceTestCase3);
        learningResources.add(learningResourceTestCase4);

        learningResourceService.saveLearningResources(learningResources);

        verify(learningResourceRepository, times(learningResources.size())).save(any(LearningResource.class));
    }

    @Test
    public void deleteLearningResourceById(){
        int learningResourceId = 1111;

        learningResourceService.deleteLearningResource(learningResourceId);

        verify(learningResourceRepository, times(1)).deleteById(learningResourceId);
    }
}
