package com.tgt.rysetti.learningresourcesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;

public interface LearningResourceRepository extends JpaRepository<LearningResource,Integer> {

}
