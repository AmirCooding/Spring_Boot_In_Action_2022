package com.Amircoding.taco_cloud_security_chapter_04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Amircoding.taco_cloud_security_chapter_04.enums.IngredientsType;
import com.Amircoding.taco_cloud_security_chapter_04.models.Ingredient;
import com.Amircoding.taco_cloud_security_chapter_04.repository.IngredientRepository;

@SpringBootApplication
public class TacoCloudSecurityChapter04Application {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudSecurityChapter04Application.class, args);
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
