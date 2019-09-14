package com.interview.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.example.exception.ManufacturerNotExistException;
import com.interview.example.model.CarDetailsModel;
import com.interview.example.model.CarManufacturerModel;
import com.interview.example.model.RequestCarDetailsModel;
import com.interview.example.repository.CarDetailsRepository;
import com.interview.example.repository.CarManufacturerRepository;

@Service
public class CarDetailsServiceImpl implements CarDetailsService{

	@Autowired
	CarDetailsRepository carDetailsRepo;
	
	@Autowired
	CarManufacturerRepository carManufacturerRepo;
	
	@Override
	public void createCarDetail(CarDetailsModel carDetailsModel) {
		// TODO Auto-generated method stub
		carDetailsRepo.save(carDetailsModel);
	}

	@Override
	public void updateCarDetail(CarDetailsModel carDetailsModel) {
		// TODO Auto-generated method stub
		carDetailsRepo.save(carDetailsModel);
	}

	@Override
	public void deleteCarDetailById(String id) {
		// TODO Auto-generated method stub
		carDetailsRepo.deleteById(id);
	}

	@Override
	public Optional<CarDetailsModel> CarDetailsFindById(String id) {
		// TODO Auto-generated method stub
		
		return carDetailsRepo.findById(id);
	}

	////////////////////////For Car Manufacturer///////////////////////////
	@Override
	public void createCarManufacturerDetail(CarManufacturerModel carManufacturerModel) {
		// TODO Auto-generated method stub
		carManufacturerRepo.save(carManufacturerModel);
	}

	@Override
	public void updateCarManufacturerDetail(CarManufacturerModel carManufacturerModel) {
		// TODO Auto-generated method stub
		carManufacturerRepo.save(carManufacturerModel);
	}

	@Override
	public void deleteCarManufacturerById(String id) {
		// TODO Auto-generated method stub
		carManufacturerRepo.deleteById(id);
	}

	@Override
	public Optional<CarManufacturerModel> CarManufacturerFindById(String id) 
	{			
		return carManufacturerRepo.findById(id);		
	}

	@Override
	public List<CarDetailsModel> findCarDetailByBrandId(RequestCarDetailsModel requestCarDetailsModel) {
		String brandId=requestCarDetailsModel.getBrandId();
		
		Optional<CarManufacturerModel>  optional=    carManufacturerRepo.findById(brandId);
		if(optional.isPresent()) {
			return carDetailsRepo.findByBrandId(brandId);
		}else {
			throw new ManufacturerNotExistException("Brand does not exist");
		}
		
		
	}

	@Override
	public CarDetailsModel findByCarName(String carName) {
		// TODO Auto-generated method stub
		
		return carDetailsRepo.findByCarName(carName);
	}

	@Override
	public List<CarManufacturerModel> getAllManufacturer() {
		// TODO Auto-generated method stub
		return carManufacturerRepo.findAll();
	}	
	
}
