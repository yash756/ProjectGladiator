package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BroughtCropDetails;
import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.LoginStatusBidder;
import com.lti.dto.RegisterBidderStatus;
import com.lti.dto.RegisterFarmerStatus;
import com.lti.dto.SoldCropDetails;
import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.exception.BidderServiceException;
import com.lti.exception.FarmerServiceException;
import com.lti.service.BidderService;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class BidderRestController {

	@Autowired
	private BidderService bidderService;
	
	@PostMapping("/registerBidder.lti")
	public RegisterBidderStatus register(@RequestBody Bidder bidder) {
		try {
			int id = bidderService.register(bidder);
			RegisterBidderStatus status = new RegisterBidderStatus();
			status.setStatus(true);
			status.setMessage("Registration successful");
			status.setRegisteredBidderId(id);
			return status;
		}
		catch(FarmerServiceException e) {
			RegisterBidderStatus status = new RegisterBidderStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	
	}
	
	@PostMapping("/loginBidder")
	public LoginStatusBidder login(@RequestBody Login login) {
		try {
			Bidder bidder = bidderService.login(login.getEmail(), login.getPassword());
			LoginStatusBidder loginStatus = new LoginStatusBidder();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setBidderId(bidder.getBidderId());
			loginStatus.setFullName(bidder.getFullName());
			return loginStatus;
		}
		catch(BidderServiceException e) {
			LoginStatusBidder loginStatus = new LoginStatusBidder();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	@GetMapping(path="/bidderBroughtCrops")
	public List<BroughtCropDetails> viewBroughtCrops(@RequestParam("bidderId") int bidderId) {
		List<BroughtCropDetails> soldList = bidderService.getBroughtCrops(bidderId);
		return soldList;
	}
}
