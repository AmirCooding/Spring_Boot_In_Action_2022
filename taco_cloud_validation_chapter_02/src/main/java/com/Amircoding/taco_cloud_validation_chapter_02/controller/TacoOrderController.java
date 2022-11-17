package com.Amircoding.taco_cloud_validation_chapter_02.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.Amircoding.taco_cloud_validation_chapter_02.models.Order;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacOrder")
public class TacoOrderController {

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String proccessOrder(@Valid Order oder, Errors errors, SessionStatus status) {
		if (errors.hasErrors()) {
			return "orderForm";
		}

		status.setComplete();
		return "redirect:/";
	}

}
