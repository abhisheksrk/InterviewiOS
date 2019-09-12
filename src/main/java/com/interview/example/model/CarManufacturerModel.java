package com.interview.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "car-manufacturer")
public class CarManufacturerModel {

	@Id
	String id;
	
	String carManufacturerName;
}
