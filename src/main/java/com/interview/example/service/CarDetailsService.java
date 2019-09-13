package com.interview.example.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.interview.example.model.CarDetailsModel;
import com.interview.example.model.CarManufacturerModel;
import com.interview.example.repository.CarDetailsRepository;


public interface CarDetailsService {

	// For Car Details Models 
	
	public void createCarDetail(CarDetailsModel carDetailsModel);
	
	public void updateCarDetail(CarDetailsModel carDetailsModel);
	
	public void deleteCarDetailById(String id);
	
	public Optional<CarDetailsModel> CarDetailsFindById(String id);
	
	// For Car Manufacturer Models
	
	public void createCarManufacturerDetail(CarManufacturerModel carManufacturerModel);
	
	public void updateCarManufacturerDetail(CarManufacturerModel carManufacturerModel);
	
	public void deleteCarManufacturerById(String id);
	
	public Optional<CarManufacturerModel> CarManufacturerFindById(String id);
	
	public List<CarDetailsModel> findCarDetailByBrandId(String brandId);
	
}
