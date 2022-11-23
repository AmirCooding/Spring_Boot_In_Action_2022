package com.Amircoding.taco_cloud_security_chapter_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Amircoding.taco_cloud_security_chapter_04.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
