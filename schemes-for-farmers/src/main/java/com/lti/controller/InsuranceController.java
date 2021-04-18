package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.InsuranceStatus;
import com.lti.entity.Insurance;
import com.lti.exception.InsuranceServiceException;
import com.lti.service.InsuranceService;

@RestController
@CrossOrigin
public class InsuranceController {
	
	@Autowired
	private InsuranceService insuranceService;
	
	@PostMapping("/calculate-premium")
	public Insurance calculate(@RequestBody Insurance insurance) {
		Insurance sample = insuranceService.calculatePremium(insurance);
		return sample;
	}
	
	@PostMapping("/apply-for-insurance")
	public InsuranceStatus apply(@RequestBody Insurance insurance) {
		try {
			int id = insuranceService.applyForInsurance(insurance);
			InsuranceStatus status = new InsuranceStatus();
			status.setStatus(true);
			status.setMessage("succesfully applied for insurance");
			status.setAppliedInsuranceId(id);
			return status;
			
		}
		catch(InsuranceServiceException e){
			InsuranceStatus status = new InsuranceStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	

}
