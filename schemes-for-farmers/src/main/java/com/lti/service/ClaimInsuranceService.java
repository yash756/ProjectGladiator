package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ClaimInsurance;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.exception.ClaimInsuranceServiceException;
import com.lti.repository.ClaimInsuranceRepository;

@Service
@Transactional
public class ClaimInsuranceService {
	
	@Autowired
	private ClaimInsuranceRepository claimInsuranceRepository;
	
	//function to claim insurance
	//from client only farmerId, loss date and cause of loss will come
	public int claim(ClaimInsurance ci) {
		
		Farmer farmer = (Farmer) claimInsuranceRepository.fetch(Farmer.class, ci.getFarmer().getId());
		
		Insurance insurance = claimInsuranceRepository.fetchInsurance(farmer.getId());
		//Insurance insurance = (Insurance) claimInsuranceRepository.fetch(Insurance.class, pNo);
		//add if-else to check if already claimed
		ci.setInsurance(insurance);
		if(claimInsuranceRepository.appliedForClaim(ci.getInsurance().getPolicyNo())) {
			throw new ClaimInsuranceServiceException("already applied for claim");
		}
		else {
			ci.setInsuranceCompany(insurance.getInsuranceCompany());
			ci.setInsureeName(insurance.getFarmer().getName());
			ci.setSumInsured(insurance.getSumInsured());
			//ci.setInsurance(insurance);
			//ci.setFarmer(farmer);
			ClaimInsurance ci1 = (ClaimInsurance) claimInsuranceRepository.save(ci); 
			return ci1.getId();
		}
	}
	
	
}
