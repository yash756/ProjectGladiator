package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.ClaimInsurance;
import com.lti.service.ApproveClaimService;

@RestController
@CrossOrigin
public class ApproveClaimsController {
	
	@Autowired
	private ApproveClaimService approveClaimService;
	
	
	@GetMapping(path = "/approveClaims")
	public List<ClaimInsurance> viewClaims(){
		List<ClaimInsurance> approvalList = approveClaimService.getClaims();
		return approvalList;
	}

}
