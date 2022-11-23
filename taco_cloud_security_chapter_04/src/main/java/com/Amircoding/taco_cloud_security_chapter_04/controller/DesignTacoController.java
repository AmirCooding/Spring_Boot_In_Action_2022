package com.Amircoding.taco_cloud_security_chapter_04.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Amircoding.taco_cloud_security_chapter_04.enums.IngredientsType;
import com.Amircoding.taco_cloud_security_chapter_04.models.Ingredient;
import com.Amircoding.taco_cloud_security_chapter_04.models.Order;
import com.Amircoding.taco_cloud_security_chapter_04.models.Taco;
import com.Amircoding.taco_cloud_security_chapter_04.repository.IngredientRepository;
import com.Amircoding.taco_cloud_security_chapter_04.repository.TacoRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	private final IngredientRepository ingredientRepo;

	private final TacoRepository tacoRepo;

	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo) {
		this.ingredientRepo = ingredientRepo;
		this.tacoRepo = tacoRepo;
	}

	@ModelAttribute(name = "taco")
	public Taco design() {
		return new Taco();
	}

	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}

	@PostMapping
	public String processDesign(
								@Valid Taco taco, Errors errors,
								@ModelAttribute Order order) {

		if (errors.hasErrors()) {
			return "design";
		}

		Taco saved = tacoRepo.save(taco);
		order.addTaco(saved);

		return "redirect:/orders/current";
	}

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));

		IngredientsType[] types = IngredientsType.values();
		for (IngredientsType type : types) {
			model.addAttribute(type.toString().toLowerCase(),
				filterByType(ingredients, type));
		}

		return "design";
	}

	private List<Ingredient> filterByType(
											List<Ingredient> ingredients, IngredientsType type) {
		return ingredients
							.stream()
							.filter(x -> x.getIngredientsType().equals(type))
							.collect(Collectors.toList());
	}
}
