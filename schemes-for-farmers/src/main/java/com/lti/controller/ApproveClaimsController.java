package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NotificationStatus;
import com.lti.dto.Status;
import com.lti.entity.ClaimInsurance;
import com.lti.exception.NotificationException;
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
	
	@PostMapping("/actually-Approve")
	public Status approve(@RequestBody ClaimInsurance claimInsurance) {
		try {
			int id = approveClaimService.approve(claimInsurance);
			NotificationStatus status = new NotificationStatus();
			status.setId(id);
			status.setMessage("Claim approved!! Notification sent to farmer");
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

}
