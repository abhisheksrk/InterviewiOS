package com.interview.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.example.model.CarDetailsModel;
import com.interview.example.model.CarManufacturerModel;
import com.interview.example.model.SearchByBrandIdModel;
import com.interview.example.service.CarDetailsService;

@RestController
public class CarDetailsController {

	@Autowired
	CarDetailsService carDetailsService;
	
	
	@RequestMapping(value = "/getCarManufacturer", method = RequestMethod.GET) 
	public List<CarManufacturerModel> carManufacturerModels(){
		return this.carDetailsService.getCarManufacturers();
		
	}
	
	@RequestMapping(value = "/getCarsByBrand" ,method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarDetailsModel>> carsDetailsByBrand(@RequestBody SearchByBrandIdModel brandId){
		return ResponseEntity.ok(this.carDetailsService.getCarsDetailsByBrand(brandId));
	}
	
	@RequestMapping(value = "/addCarDetails", method = RequestMethod.POST)
	public ResponseEntity<CarDetailsModel> addCarDetails(@RequestBody CarDetailsModel carDetailsModel){
		return this.carDetailsService.addCarDetails(carDetailsModel);
	}
	
	
	
	
}
