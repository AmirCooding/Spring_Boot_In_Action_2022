package com.Amircoding.taco_cloud_validation_chapter_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TacoCloudValidationChapter03Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudValidationChapter03Application.class, args);

	}

//	If we need such an implementation, it is better to create a new class for the config file
	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/").setViewName("home"); }
	 */
}
