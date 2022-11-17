package com.Amircoding.taco_cloud_validation_chapter_03.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.Amircoding.taco_cloud_validation_chapter_03.enums.IngredientsType;
import com.Amircoding.taco_cloud_validation_chapter_03.models.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	Map<String, Ingredient> ingredientMap = new HashMap<>();

	public IngredientByIdConverter() {
		ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", IngredientsType.WRAP));
		ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", IngredientsType.WRAP));
		ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", IngredientsType.PROTEIN));
		ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", IngredientsType.PROTEIN));
		ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", IngredientsType.VEGGIES));
		ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", IngredientsType.VEGGIES));
		ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", IngredientsType.CHEESE));
		ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", IngredientsType.CHEESE));
		ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", IngredientsType.SAUCE));
		ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", IngredientsType.SAUCE));
	}

	@Override
	public Ingredient convert(String id) {

		return ingredientMap.get(id);
	}
}