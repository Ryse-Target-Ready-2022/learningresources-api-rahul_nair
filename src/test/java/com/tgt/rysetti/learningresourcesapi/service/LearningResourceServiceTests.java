package com.tgt.rysetti.learningresourcesapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    public void saveTheLearningResources(){
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        LearningResource learningResource3 = new LearningResource(1313, "Test Name 3", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);
        learningResources.add(learningResource3);

        learningResourceService.saveLearningResources(learningResources);

        verify(learningResourceRepository, times(learningResources.size())).save(any(LearningResource.class));
    }

    @Test
    public void deleteLearningResourceById(){
        int learningResourceId = 1234;

        learningResourceService.deleteLearningResource(learningResourceId);

        verify(learningResourceRepository, times(1)).deleteById(learningResourceId);
    }
}
