package com.interview.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.interview.example.model.CarDetailsModel;

public interface CarDetailsRepository extends MongoRepository<CarDetailsModel, String>{

	List<CarDetailsModel> findByBrandId(String brandId);
}
