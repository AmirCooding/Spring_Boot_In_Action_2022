package com.AmirCoding.taco_cloud_restapi_chapter_07.models;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoListRepository extends PagingAndSortingRepository<Taco, Long> {

}
