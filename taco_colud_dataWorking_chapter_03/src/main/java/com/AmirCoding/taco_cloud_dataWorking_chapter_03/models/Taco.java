package com.AmirCoding.taco_cloud_dataWorking_chapter_03.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)

public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 4, message = "Name must be at least 4 characters long")
	private String name;

	private Date createdAt;

	@Size(min = 1, message = "You must choose at least 1 ingredient")
	@OneToMany()
	private List<Ingredient> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}
