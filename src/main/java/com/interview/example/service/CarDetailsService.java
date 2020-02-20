package com.interview.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interview.example.model.CarDetailsModel;
import com.interview.example.model.CarManufacturerModel;
import com.interview.example.model.SearchByBrandIdModel;
import com.interview.example.repository.CarDetailsRepository;
import com.interview.example.repository.CarManufacturerRepository;

@Service
public class CarDetailsService {

  private static final Logger logger = LogManager.getLogger(CarDetailsService.class);

  @Autowired
  CarManufacturerRepository carManufacturerRepository;


  @Autowired
  CarDetailsRepository carDetailsRepository;

  public List<CarManufacturerModel> getCarManufacturers() {

    return this.carManufacturerRepository.findAll();
  }

  public List<CarDetailsModel> getCarsDetailsByBrand(SearchByBrandIdModel byBrandIdModel) {

    String brandId = byBrandIdModel.getBrandId();

    List<CarDetailsModel> carDetailsModels = new ArrayList<CarDetailsModel>();
    carDetailsModels = carDetailsRepository.findByBrandId(brandId);
    return carDetailsModels;
  }

  public ResponseEntity<CarDetailsModel> addCarDetails(CarDetailsModel carDetailsModel) {
    carDetailsRepository.save(carDetailsModel);
    return ResponseEntity.ok(carDetailsModel);
  }


}
