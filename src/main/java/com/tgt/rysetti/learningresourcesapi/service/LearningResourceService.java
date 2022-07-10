package com.tgt.rysetti.learningresourcesapi.service;


import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;

import com.tgt.rysetti.learningresourcesapi.repository.LearningResourceRepository;

@Service
public class LearningResourceService {
	@Autowired
	private  LearningResourceRepository repo;
    


	public  List<LearningResource>  getLearningResources()
	{
		return repo.findAll();
	}
	
	public  void saveLearningResources(List<LearningResource> learningResources)
	{
		for (LearningResource learningResource : learningResources)
		{
            repo.save(learningResource);
		}
		 
		
	}
	
	public  TreeMap<Double,LearningResource> sortedLearningResource()
	{
		List<LearningResource> resources = getLearningResources();
		TreeMap<Double,LearningResource> map=new TreeMap<>();
		for(LearningResource lr : resources)
		{
			Double cp= lr.getCostPrice();
			Double sp= lr.getSellingPrice();
			Double margin=(sp-cp)/sp;
			map.put(margin, lr);
		}
		return map;
	}

	
	
	
	
	
	
}
