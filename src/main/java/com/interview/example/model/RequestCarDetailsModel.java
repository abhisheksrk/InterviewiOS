package com.interview.example.model;

import javax.validation.constraints.NotBlank;

public class RequestCarDetailsModel {
	@NotBlank(message="Brand Id Can Not Be Null")
	String brandId;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	@Override
	public String toString() {
		return "RequestCarDetailsModel [brandId=" + brandId + "]";
	}
	
}
