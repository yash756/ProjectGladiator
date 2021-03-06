package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.lti.dto.FarmerMarketPlaceCrops;
import com.lti.dto.Login;
import com.lti.dto.LoginStatus;

import com.lti.dto.NotificationStatus;

import com.lti.dto.RegisterFarmerStatus;
import com.lti.dto.SoldCropDetails;
import com.lti.dto.Status;

import com.lti.dto.Status;
import com.lti.entity.Bid;

//import com.lti.entity.Bid;

import com.lti.entity.Farmer;

import com.lti.entity.Notification;
import com.lti.entity.Request;


import com.lti.entity.MarketPlace;
//import com.lti.entity.Request;

import com.lti.exception.FarmerServiceException;
import com.lti.exception.NotificationException;
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
	
	@GetMapping(path="/farmerSoldCrops")
	public List<SoldCropDetails> viewSoldCrops(@RequestParam("farmerId") int farmerId) {
		List<SoldCropDetails> soldList = farmerService.getSoldCrops(farmerId);
		return soldList;

	}
	
	@GetMapping(path="/farmerUnSoldCrops")
	public List<MarketPlace> viewUnSoldCrops(@RequestParam("farmerId") int farmerId) {
		List<MarketPlace> soldList = farmerService.getUnSoldCrops(farmerId);
		return soldList;

	}
	
	@PostMapping("/notified")
	/*public Notification notified(@RequestBody Farmer farmer) {
		return farmerService.getNotified(farmer.getId());
		//return notification;
	}*/
	
	public Status notified(@RequestBody Farmer farmer) {
		try {
			Notification notification = farmerService.getNotified(farmer.getId());
			NotificationStatus status = new NotificationStatus();
			status.setId(notification.getNotificationId());
			status.setMessage(notification.getContent());
			status.setStatus(true);
			return status;
		}
		catch (NotificationException e) {
			NotificationStatus status = new NotificationStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
			
		}
	}
	
	/*@PostMapping("/pic-upload")
	public Status upload(ProfilePic profilePicDetails) {
		int farmerId = profilePicDetails.getFarmerId();
		
		String imgUploadLocation = "C:\\Users\\vadde\\Documents\\Training\\uploads";
		String uploadedFileName = profilePicDetails.getProfilePic().getOriginalFilename();
		String newFileName = farmerId + "-" + uploadedFileName;
		String targetFileName = imgUploadLocation + newFileName;
		
		try {
			FileCopyUtils.copy(profilePicDetails.getProfilePic().getInputStream(), new FileOutputStream(targetFileName));
		}
		catch(IOException e) {
			e.printStackTrace(); //hope no error would occur
			Status status = new Status();
			status.setStatus(false);
			status.setMessage("Profilepic upload failed!");
		}
		
		farmerService.updateProfilePic(farmerId, newFileName);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessage("Profilepic uploaded successfully!");
		return status;
	}*/
}
