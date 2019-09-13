package com.interview.example.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "car-manufacturer")
public class CarManufacturerModel {

	@Id
	String id;
	@NotEmpty(message="Manufactor Filed should not be empty")
	String carManufacturerName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarManufacturerName() {
		return carManufacturerName;
	}
	public void setCarManufacturerName(String carManufacturerName) {
		this.carManufacturerName = carManufacturerName;
	}
	@Override
	public String toString() {
		return "CarManufacturerModel [id=" + id + ", carManufacturerName=" + carManufacturerName + "]";
	}
	
}
