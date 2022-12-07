package com.Amircoding.taco_cloud_security_chapter_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Amircoding.taco_cloud_security_chapter_04.models.UsersDetails;

@Repository
public interface UserRepository extends JpaRepository<UsersDetails, Long> {
	UsersDetails findByUsername(String username);

}
