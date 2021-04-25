package com.lti.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ClaimInsurance;
import com.lti.repository.ApproveInsuranceRepository;

@Service
@Transactional
public class ApproveClaimService {
	
	@Autowired
	private ApproveInsuranceRepository approveInsuranceRepository;
	
	@Autowired
	//private MailSender mailsender;
	
	public List<ClaimInsurance> getClaims(){
		List<ClaimInsurance> list = approveInsuranceRepository.fetchClaims();
		return list;
	}
	
	//testing email functionality
	public void sendEmail() {
		
	}

}
