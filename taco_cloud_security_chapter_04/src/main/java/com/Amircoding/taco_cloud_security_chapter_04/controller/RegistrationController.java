package com.Amircoding.taco_cloud_security_chapter_04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Amircoding.taco_cloud_security_chapter_04.models.RegistrationForm;
import com.Amircoding.taco_cloud_security_chapter_04.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping
	public String ProccessRegistration(RegistrationForm form) {
		userRepository.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}

	@GetMapping
	public String registrationForm() {
		return "registration";
	}

}
