package com.Amircoding.taco_cloud_security_chapter_04.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.Amircoding.taco_cloud_security_chapter_04.enums.IngredientsType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private final String id;
	private final String name;
	private IngredientsType ingredientsType;

}
