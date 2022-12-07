package com.AmirCoding.taco_cloud_restapi_chapter_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AmirCoding.taco_cloud_restapi_chapter_07.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
