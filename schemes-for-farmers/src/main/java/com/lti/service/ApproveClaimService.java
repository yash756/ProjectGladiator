package com.lti.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ClaimInsurance;
import com.lti.entity.Farmer;
import com.lti.entity.Notification;
import com.lti.exception.NotificationException;
import com.lti.repository.ApproveInsuranceRepository;
import com.lti.repository.NotificationRepository;

@Service
@Transactional
public class ApproveClaimService {
	
	@Autowired
	private ApproveInsuranceRepository approveInsuranceRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	//private MailSender mailsender;
	
	public List<ClaimInsurance> getClaims(){
		List<ClaimInsurance> list = approveInsuranceRepository.fetchClaims();
		return list;
	}
	
	//testing email functionality
	public void sendEmail() {
		
	}
	
	//function to store content for notification after approval
	//add if-else condition to check if already approved
	public int approve(ClaimInsurance claimInsurance) {
		Farmer farmer = (Farmer) notificationRepository.fetch(Farmer.class, claimInsurance.getFarmer().getId());
		
		if(notificationRepository.alreadyNotified(farmer.getId())) {
			throw new NotificationException("this claim has been already approved");
		}
		else {
			Notification notification = new Notification();
			notification.setContent("Your claim for insurance has been approved by the admin.");
			notification.setFarmer(farmer);
			notificationRepository.save(notification);
			return notification.getNotificationId();
		}
	}

}
