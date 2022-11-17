package com.Amircoding.taco_cloid_chapter02.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Amircoding.taco_cloid_chapter02.enums.IngredientsType;
import com.Amircoding.taco_cloid_chapter02.models.Ingredient;
import com.Amircoding.taco_cloid_chapter02.models.Order;
import com.Amircoding.taco_cloid_chapter02.models.Taco;

import lombok.extern.slf4j.Slf4j;

@Controller
//Indicates that all user requests to url ("/design")
//are handled by this handler
@RequestMapping("/design")
//as long as users surf of this website and select something, all things will be saved in this session
@SessionAttributes("tacoOrder")
@Slf4j
public class DesignTacoController {

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
			new Ingredient("FLTO", "Flour Tortilla", IngredientsType.WRAP),
			new Ingredient("COTO", "Corn Tortilla", IngredientsType.WRAP),
			new Ingredient("GRBF", "Ground Beef", IngredientsType.PROTEIN),
			new Ingredient("CARN", "Carnitas", IngredientsType.PROTEIN),
			new Ingredient("TMTO", "Diced Tomatoes", IngredientsType.VEGGIES),
			new Ingredient("LETC", "Lettuce", IngredientsType.VEGGIES),
			new Ingredient("CHED", "Cheddar", IngredientsType.CHEESE),
			new Ingredient("JACK", "Monterrey Jack", IngredientsType.CHEESE),
			new Ingredient("SLSA", "Salsa", IngredientsType.SAUCE),
			new Ingredient("SRCR", "Sour Cream", IngredientsType.SAUCE)

		);
		IngredientsType[] types = IngredientsType.values();
		for (IngredientsType type : types) {
			model.addAttribute(type.toString().toLowerCase(),
				filterByType(ingredients, type));

			System.out.println(type.toString().toLowerCase());
		}
		model.addAttribute("design", new Taco());

	}

	@ModelAttribute("tacoOrder")
	public Order order() {
		return new Order();

	}

	@PostMapping
	public String proccessTacoString(Taco taco, @ModelAttribute Order tacoOrder) {

		tacoOrder.addTaco(taco);
		log.info("Processing Tco : {} ", taco);
		System.out.println(taco.getName().toString());
		return "redirect:/orders/current";
	}

	@GetMapping
	public String showDesign() {
		return "design";
	}

	@ModelAttribute("taco")
	public Taco taco() {
		return new Taco();
	}

	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngredientsType type) {

		return ingredients	.stream()
							.filter(x -> x.getIngredientsType().equals(type))
							.collect(Collectors.toList());
	}

}
