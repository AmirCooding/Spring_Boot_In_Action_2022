package com.AmirCoding.taco_cloud_dataWorking_chapter_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AmirCoding.taco_cloud_dataWorking_chapter_03.models.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
