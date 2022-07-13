package com.tgt.rysetti.learningresourcesapi.service;


import java.util.List;
import static java.util.stream.Collectors.toList;

import java.util.Optional;
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
	
	public List<Double> getProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();

        List<Double> profitMargins = learningResources.stream().map(lr -> ((lr.getSellingPrice() - lr.getCostPrice())/lr.getSellingPrice()))
                                            .collect(toList());

        return profitMargins;
    }
	
	public  TreeMap<Double,LearningResource> sortedLearningResourceByProfitMargin()
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
    
	public Optional<LearningResource> getLearningResourceById(int id)
	{
		return repo.findById(id);
	}
	
	public String updateLearningResource(int id,LearningResource learningresource)
	{
		if(repo.existsById(id))
		{
			repo.save(learningresource);
			return "Record updated successfully";
		}
		else
			return "The record doesn't exist";
	}
	
	public void deleteLearningResource(int id)
	{
		repo.deleteById(id);
	}
	
	
	
}
