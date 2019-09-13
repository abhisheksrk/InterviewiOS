package com.interview.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.interview.example.model.CarManufacturerModel;
@Repository
public interface CarManufacturerRepository extends MongoRepository<CarManufacturerModel, String>{

}
