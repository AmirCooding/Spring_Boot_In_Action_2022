package com.Amircoding.taco_cloud_validation_chapter_02.models;

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
	@Size(min = 1, message = "dxfgsrjsdxrztjk")
	private List<String> ingredients;
	@NotNull
	@Size(min = 4, message = "Name must be at least 4 charectar long")
	private String name;

}
