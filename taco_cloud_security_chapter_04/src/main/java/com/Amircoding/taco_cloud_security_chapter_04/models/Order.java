package com.Amircoding.taco_cloud_security_chapter_04.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "order_Taco")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Order implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date placedAt;
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
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Taco> tacos = new ArrayList<>();

	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}

	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
}