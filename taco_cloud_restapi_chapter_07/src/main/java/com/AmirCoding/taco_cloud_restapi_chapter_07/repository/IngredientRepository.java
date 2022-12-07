package com.AmirCoding.taco_cloud_restapi_chapter_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AmirCoding.taco_cloud_restapi_chapter_07.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
