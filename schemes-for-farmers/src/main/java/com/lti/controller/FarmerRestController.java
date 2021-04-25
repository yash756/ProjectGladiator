package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.FarmerMarketPlaceCrops;
import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterFarmerStatus;
import com.lti.entity.Farmer;
import com.lti.entity.MarketPlace;
import com.lti.exception.FarmerServiceException;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class FarmerRestController {

	@Autowired
	private FarmerService farmerService;
	
	@PostMapping("/registerFarmer.lti")
	public RegisterFarmerStatus register(@RequestBody Farmer farmer) {
		try {
			int id = farmerService.register(farmer);
			RegisterFarmerStatus status = new RegisterFarmerStatus();
			status.setStatus(true);
			status.setMessage("Registration successful");
			status.setRegisteredFarmerId(id);
			return status;
		}
		catch(FarmerServiceException e) {
			RegisterFarmerStatus status = new RegisterFarmerStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	
	}
	
	@PostMapping("/loginFarmer")
	public LoginStatus login(@RequestBody Login login) {
		try {
			Farmer farmer = farmerService.login(login.getEmail(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setFarmerId(farmer.getId());
			loginStatus.setFullName(farmer.getName());
			return loginStatus;
		}
		catch(FarmerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	@GetMapping("/fetchFarmerMarketPlace")
	public List<MarketPlace> viewMarketPlace(@RequestParam("id") int id) {
		List<MarketPlace> marketPlace = farmerService.getMarketPlaceCrops(id);
		return marketPlace;
	}
}
