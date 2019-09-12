package com.interview.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.interview.example.model.CarManufacturerModel;

public interface CarManufacturerRepository extends MongoRepository<CarManufacturerModel, String>{

}
