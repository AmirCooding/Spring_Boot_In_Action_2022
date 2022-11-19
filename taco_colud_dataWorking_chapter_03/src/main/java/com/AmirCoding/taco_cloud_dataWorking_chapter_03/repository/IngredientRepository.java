package com.AmirCoding.taco_cloud_dataWorking_chapter_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AmirCoding.taco_cloud_dataWorking_chapter_03.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
