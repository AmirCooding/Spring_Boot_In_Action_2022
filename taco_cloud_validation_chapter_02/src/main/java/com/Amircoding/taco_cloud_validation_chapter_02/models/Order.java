package com.Amircoding.taco_cloud_validation_chapter_02.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)

public class Order {
	@NotBlank(message = "Name is required")
	private String deliveryName;
	@NotBlank(message = "Street is required")
	private String deliveryStreet;
	@NotBlank(message = "City is required")
	private String deliveryCity;
	@NotBlank(message = "State is required")
	private String deliveryState;
	@NotBlank(message = "Zip is required")
	private String deliveryZip;

	/*
	 * This annotation declares that the property’s value must be a valid credit
	 * card number that passes the Luhn algorithm
	 */
	@CreditCardNumber(message = "not valid credit card number")
	private String deliveryccNumber;
	/*
	 * http://www.regularexpressions. info
	 */
	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "must be formated MM/YY")
	private String deliveryccExpiration;
	@Digits(integer = 3, fraction = 0, message = "invalid CVV")
	private String deliveryccVV;
	private List<Taco> tacos = new ArrayList<>();

	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
}