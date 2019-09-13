package com.interview.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.interview.example.model.CarDetailsModel;
@Repository
public interface CarDetailsRepository extends MongoRepository<CarDetailsModel, String>{

	public List<CarDetailsModel> findByBrandId(String brandId);
}
