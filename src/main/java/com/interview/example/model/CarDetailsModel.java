package com.interview.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "car-details")
public class CarDetailsModel {

	@Id
	String id;
	
	String brandId;
	String carName;
	String carDescription;
	String imageLink;
	
}
