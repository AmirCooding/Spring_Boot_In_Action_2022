package com.AmirCoding.taco_colud_dataWorking_chapter_03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.AmirCoding.taco_colud_dataWorking_chapter_03.enums.IngredientsType;
import com.AmirCoding.taco_colud_dataWorking_chapter_03.models.Ingredient;
import com.AmirCoding.taco_colud_dataWorking_chapter_03.repository.IngredientRepository;

@SpringBootApplication
public class TacoColudDataWorkingChapter03Chapter03Application {

	public static void main(String[] args) {
		SpringApplication.run(TacoColudDataWorkingChapter03Chapter03Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientsType.WRAP));
			repo.save(new Ingredient("COTO", "Corn Tortilla", IngredientsType.WRAP));
			repo.save(new Ingredient("GRBF", "Ground Beef", IngredientsType.PROTEIN));
			repo.save(new Ingredient("CARN", "Carnitas", IngredientsType.PROTEIN));
			repo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientsType.VEGGIES));
			repo.save(new Ingredient("LETC", "Lettuce", IngredientsType.VEGGIES));
			repo.save(new Ingredient("CHED", "Cheddar", IngredientsType.CHEESE));
			repo.save(new Ingredient("JACK", "Monterrey Jack", IngredientsType.CHEESE));
			repo.save(new Ingredient("SLSA", "Salsa", IngredientsType.SAUCE));
			repo.save(new Ingredient("SRCR", "Sour Cream", IngredientsType.SAUCE));
		};
	}

}
