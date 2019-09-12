package com.interview.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.interview.example.model.CarDetailsModel;

public interface CarDetailsRepository extends MongoRepository<CarDetailsModel, String>{

}
