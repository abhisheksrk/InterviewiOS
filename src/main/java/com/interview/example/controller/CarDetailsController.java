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
import com.interview.example.model.RequestCarDetailsModel;
import com.interview.example.service.CarDetailsService;
import com.mongodb.diagnostics.logging.Logger;

@RestController
public class CarDetailsController {

	@Autowired
	CarDetailsService carDetailsService;
	
	public static String responseCode ;
	
	@PostMapping(value= "/createcardetail")
	public String createcardetail(@Valid@RequestBody CarDetailsModel carDetailsModel)throws Exception {
		CarDetailsModel carModel ;
		try {
			carModel= carDetailsService.findByCarName(carDetailsModel.getCarName());
			if(carModel==null)
			{
				responseCode = "Data Added Sucessfully";
				carDetailsService.createCarDetail(carDetailsModel);
			}
			else {
				responseCode = "Car name Already Exist !!";
			}			
		}catch(Exception ex) {	
			System.out.println("Exception : "+ex);
		}
		return responseCode;
	}
	
	@PutMapping(value="/updatecardetail/{car-id}")
	public String updatecardetail(@PathVariable(value="car-id") String id,@RequestBody CarDetailsModel carDetailsModel)
	{
		responseCode="Car updated";
		
		carDetailsService.updateCarDetail(carDetailsModel);
		return responseCode;
	}
	
	@DeleteMapping(value="/deletecardetail/{car-id}")
	public String deletecardetail(@PathVariable(value= "car-id") String id) 
	{
		responseCode="Car Deleted";
		carDetailsService.deleteCarDetailById(id);
		return responseCode;
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
		responseCode="Car Menufacturer Added";
		carDetailsService.createCarManufacturerDetail(carManufacturerModel);
		return responseCode;
	}
	
	@PutMapping(value="/updatecarmanufacturerdetail/{car-id}")
	public String updatecarmanufacturerdetail(@PathVariable(value="car-id") String id,@RequestBody CarManufacturerModel carManufacturerModel)
	{
		responseCode="Car Menufacturer Updated";
		//carDetailsModel.set(id);
		carDetailsService.updateCarManufacturerDetail(carManufacturerModel);
		return responseCode;
	}
	
	@DeleteMapping(value="/deletecarmenufacturerdetail/{car-id}")
	public String deletecarmenufacturerdetail(@PathVariable(value= "car-id") String id) 
	{
		responseCode="Car Manufacturer Deleted";
		carDetailsService.deleteCarDetailById(id);
		return responseCode;
	}
	
	@GetMapping(value="/getcarmenufacturerbyid/{car-id}")
	public Optional<CarManufacturerModel> getCarMenufacturerById(@PathVariable(value= "car-id") String id)
	{
		return carDetailsService.CarManufacturerFindById(id);
	}
	
	@PostMapping(value="/findByBrandId")
	public List<CarDetailsModel> findByBrandId(@RequestBody RequestCarDetailsModel requestCarDetailsModel) 
	{
			return carDetailsService.findCarDetailByBrandId(requestCarDetailsModel);
	}
	
	@GetMapping(value="/getAllManufacturer")
	public List<CarManufacturerModel> getAllManufacturer()
	{
		return carDetailsService.getAllManufacturer();
	}
	
}
