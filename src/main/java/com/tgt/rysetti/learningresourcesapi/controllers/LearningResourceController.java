package com.tgt.rysetti.learningresourcesapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetti.learningresourcesapi.service.LearningResourceService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/learningresources")
public class LearningResourceController {
	
	@Autowired
	private LearningResourceService service;
	
	@GetMapping("/all")
	public List<LearningResource> getAllLearningResources()
	{
		return service.getLearningResources();
	}
	
	@GetMapping("/{id}")
	public Optional<LearningResource> getLearningResourceById(@PathVariable int id)
	{
		return service.getLearningResourceById(id);
	}
	
	@PostMapping(value = "/", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveLearningResources(@RequestBody List<LearningResource> learningresources)
	{
		service.saveLearningResources(learningresources);
	}
	
	@PutMapping("/update/{id}")
	public String updateLearningResource(@PathVariable int id,@RequestBody LearningResource learningresource)
	{
		return service.updateLearningResource(id, learningresource);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLearningResource(@PathVariable int id)
	{
		service.deleteLearningResource(id);
	}
	
}
