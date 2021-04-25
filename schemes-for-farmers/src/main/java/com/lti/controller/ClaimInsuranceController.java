package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ClaimInsuranceStatus;
import com.lti.entity.ClaimInsurance;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.exception.ClaimInsuranceServiceException;
import com.lti.service.ClaimInsuranceService;
import com.lti.service.InsuranceService;

@RestController
@CrossOrigin
public class ClaimInsuranceController {
	
	@Autowired
	private ClaimInsuranceService cis;
	
	@Autowired
	private InsuranceService insuranceService;
	
	@PostMapping("/claim-insurance")
	public ClaimInsuranceStatus claim(@RequestBody ClaimInsurance claimInsurance) {
		try {
			int id = cis.claim(claimInsurance);
			ClaimInsuranceStatus status = new ClaimInsuranceStatus();
			status.setStatus(true);
			status.setMessage("submitted for approval from admin");
			status.setClaimedInsuranceId(id);
			return status;
		}
		catch (ClaimInsuranceServiceException e) {
			ClaimInsuranceStatus status = new ClaimInsuranceStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	//test on boomerrang
	
	//method to partially fill the claim form
	@PostMapping("/fetch-insurance-details")
	public Insurance fetch(@RequestBody Farmer farmer) {
		return cis.fetchDetails(farmer.getId());
	}

}
