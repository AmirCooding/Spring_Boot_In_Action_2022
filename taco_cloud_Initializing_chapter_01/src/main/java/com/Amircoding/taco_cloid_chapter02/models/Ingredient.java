package com.Amircoding.taco_cloid_chapter02.models;

import com.Amircoding.taco_cloid_chapter02.enums.IngredientsType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient {
	private final String id;
	private final String name;
	private final IngredientsType ingredientsType;

}
