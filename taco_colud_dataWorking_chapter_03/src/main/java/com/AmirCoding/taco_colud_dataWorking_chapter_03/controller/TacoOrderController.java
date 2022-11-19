package com.AmirCoding.taco_colud_dataWorking_chapter_03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.AmirCoding.taco_colud_dataWorking_chapter_03.models.Order;
import com.AmirCoding.taco_colud_dataWorking_chapter_03.repository.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacOrder")
public class TacoOrderController {
	private OrderRepository orderRepo;

	public TacoOrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String proccessOrder(@Valid Order order, Errors errors, SessionStatus status) {
		if (errors.hasErrors()) {
			return "orderForm";
		}
		orderRepo.save(order);
		status.setComplete();
		return "redirect:/";
	}

}
