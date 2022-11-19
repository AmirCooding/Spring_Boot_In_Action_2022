package com.AmirCoding.taco_colud_dataWorking_chapter_03.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.AmirCoding.taco_colud_dataWorking_chapter_03.enums.IngredientsType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Ingredient implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private final String name;
	private IngredientsType ingredientsType;

}
