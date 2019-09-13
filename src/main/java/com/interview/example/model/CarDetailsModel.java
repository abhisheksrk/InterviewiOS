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
@Document(collection = "car-details")
public class CarDetailsModel {

	@Id
	String id;
	@NotEmpty(message = "BranchId Must Be Required")
	String brandId;
	@NotEmpty(message = "Car Name Must Be Required")
	String carName;
	@NotEmpty(message = "Car Description Must Be Required")
	String carDescription;
	@NotEmpty(message = "ImageLink Must Be Required")
	String imageLink;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarDescription() {
		return carDescription;
	}
	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	@Override
	public String toString() {
		return "CarDetailsModel [id=" + id + ", brandId=" + brandId + ", carName=" + carName + ", carDescription="
				+ carDescription + ", imageLink=" + imageLink + "]";
	}
	
	
}
