package com.interview.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.example.exception.RecordNotFoundException;
import com.interview.example.model.CarDetailsModel;
import com.interview.example.model.CarManufacturerModel;
import com.interview.example.service.CarDetailsService;

@RestController
public class CarDetailsController {

	@Autowired
	CarDetailsService carDetailsService;
	
	@PostMapping(value= "/createcardetail")
	public ResponseEntity<CarDetailsModel> createcardetail(@Valid@RequestBody CarDetailsModel carDetailsModel)throws Exception {
		
		carDetailsService.createCarDetail(carDetailsModel);
		//return "Car Added";
		return new ResponseEntity<CarDetailsModel>(carDetailsModel, HttpStatus.OK);
	}
	
	@PutMapping(value="/updatecardetail/{car-id}")
	public String updatecardetail(@PathVariable(value="car-id") String id,@RequestBody CarDetailsModel carDetailsModel)
	{
		carDetailsService.updateCarDetail(carDetailsModel);
		return "Car Updated";
	}
	
	@DeleteMapping(value="/deletecardetail/{car-id}")
	public String deletecardetail(@PathVariable(value= "car-id") String id) 
	{
		carDetailsService.deleteCarDetailById(id);
		return "Car Deleted";
	}
	/*
	@GetMapping(value="/getcarbyid/{car-id}")
	public ResponseEntity<CarDetailsModel> getCarById(@PathVariable(value= "car-id") String id)
	{
		CarDetailsModel carModel=carDetailsService.CarDetailsFindById(id);
		if(carModel == null) {
	         throw new RecordNotFoundException("Invalid Car id : " + id);
	    }
	    return new ResponseEntity<CarDetailsModel>(carModel, HttpStatus.OK);
	}
	*/
	
	/////////////////////////// For Car Manufacturer ////////////////////////////
	
	
	@PostMapping(value= "/createcarmanufacturerdetail")
	public String createcarmanufacturerdetail(@RequestBody CarManufacturerModel carManufacturerModel) {
		
		carDetailsService.createCarManufacturerDetail(carManufacturerModel);
		return "Car Menufacturer Added";
	}
	
	@PutMapping(value="/updatecarmanufacturerdetail/{car-id}")
	public String updatecarmanufacturerdetail(@PathVariable(value="car-id") String id,@RequestBody CarManufacturerModel carManufacturerModel)
	{
		//carDetailsModel.set(id);
		carDetailsService.updateCarManufacturerDetail(carManufacturerModel);
		return "Car Menufacturer Updated";
	}
	
	@DeleteMapping(value="/deletecarmenufacturerdetail/{car-id}")
	public String deletecarmenufacturerdetail(@PathVariable(value= "car-id") String id) 
	{
		carDetailsService.deleteCarDetailById(id);
		return "Car Manufacturer Deleted";
	}
	
	@GetMapping(value="/getcarmenufacturerbyid/{car-id}")
	public Optional<CarManufacturerModel> getCarMenufacturerById(@PathVariable(value= "car-id") String id)
	{
		return carDetailsService.CarManufacturerFindById(id);
	}
	
	@GetMapping(value="/findbybrandid/{car-id}")
	public List<CarDetailsModel> findByBrandId(@PathVariable(value="car-id")String brandId) 
	{
			return carDetailsService.findCarDetailByBrandId(brandId);
	}
	
}
