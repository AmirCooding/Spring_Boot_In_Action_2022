package com.AmirCoding.taco_cloud_restapi_chapter_07.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.AmirCoding.taco_cloud_restapi_chapter_07.enums.IngredientsType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Ingredient {

	@Id
	private String id;
	private final String name;
	private IngredientsType ingredientsType;

}
