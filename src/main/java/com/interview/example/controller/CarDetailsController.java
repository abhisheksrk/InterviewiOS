package com.interview.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.interview.example.service.CarDetailsService;

@RestController
public class CarDetailsController {

	@Autowired
	CarDetailsService carDetailsService;
	
	
	
}
