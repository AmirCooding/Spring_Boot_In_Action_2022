package com.Amircoding.taco_cloud_security_chapter_04.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String fullname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public UsersDetails toUser(PasswordEncoder passwordEncoder) {
		return new UsersDetails(
			username, passwordEncoder.encode(password),
			fullname, street, city, state, zip, phone);
	}

}
