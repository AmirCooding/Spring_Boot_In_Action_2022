package com.AmirCoding.taco_cloud_restapi_chapter_07.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.AmirCoding.taco_cloud_restapi_chapter_07.models.Taco;
import com.AmirCoding.taco_cloud_restapi_chapter_07.models.TacoListRepository;

@Controller
public class TacoListController {
	private TacoListRepository listRepository;

	@GetMapping(params = "recent")
	public Iterable<Taco> recentTacos() {

		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return listRepository.findAll(page).getContent();
	}

}
