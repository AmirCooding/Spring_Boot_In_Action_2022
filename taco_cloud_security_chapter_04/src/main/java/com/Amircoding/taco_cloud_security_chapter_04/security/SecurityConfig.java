package com.Amircoding.taco_cloud_security_chapter_04.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Amircoding.taco_cloud_security_chapter_04.models.UsersDetails;
import com.Amircoding.taco_cloud_security_chapter_04.repository.UserRepository;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
					.authorizeRequests()
					.antMatchers("/design", "/orders")
					.access("hasRole('USER')")
					.antMatchers("/", "/**")
					.access("permitAll()")
					.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/design", true)
					.and()
					.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return username -> {
			UsersDetails user = userRepository.findByUsername(username);
			System.out.println(user);
			if (user != null) {
				System.out.print("usename is found");
				return user;
			}
			throw new UsernameNotFoundException("user " + username + " notfound");

		};
	}

}
