package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ClaimInsuranceStatus;
import com.lti.entity.ClaimInsurance;
import com.lti.exception.ClaimInsuranceServiceException;
import com.lti.service.ClaimInsuranceService;

@RestController
@CrossOrigin
public class ClaimInsuranceController {
	
	@Autowired
	private ClaimInsuranceService cis;
	
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

}
