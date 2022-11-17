package com.Amircoding.taco_cloid_chapter_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.Amircoding.taco_cloid_chapter_01.models.Order;

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
	public String proccessOrder(Order oder, SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

}
