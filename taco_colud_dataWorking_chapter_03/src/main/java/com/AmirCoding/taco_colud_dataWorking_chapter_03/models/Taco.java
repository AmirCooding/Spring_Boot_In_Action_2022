package com.AmirCoding.taco_colud_dataWorking_chapter_03.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Taco implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min = 4, message = "Name must be at least 5 charectar long")
	private String name;
	private Date createdAt;
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	@ManyToMany(targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

}
