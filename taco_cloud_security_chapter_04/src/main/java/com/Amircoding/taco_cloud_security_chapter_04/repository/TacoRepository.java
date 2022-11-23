package com.Amircoding.taco_cloud_security_chapter_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Amircoding.taco_cloud_security_chapter_04.models.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
