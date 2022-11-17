package com.Amircoding.taco_cloud_validation_chapter_03.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Taco {
	@NotNull
	@Size(min = 4, message = "Name must be at least 5 charectar long")
	private String name;
	@NotNull
	@Size(min = 1, message = "you must choose at least ingredient")
	private List<String> ingredients;

}
