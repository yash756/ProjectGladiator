package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ClaimInsurance;
import com.lti.entity.Insurance;
import com.lti.repository.ClaimInsuranceRepository;

@Service
@Transactional
public class ClaimInsuranceService {
	
	@Autowired
	private ClaimInsuranceRepository claimInsuranceRepository;
	
	//function to claim insurance
	//from client only policy number, loss date and cause of loss will come
	public int claim(ClaimInsurance ci) {
		Insurance insurance = (Insurance) claimInsuranceRepository.fetch(Insurance.class, ci.getInsurance().getPolicyNo());
		//add if-else to check if already claimed
		ci.setInsuranceCompany(insurance.getInsuranceCompany());
		ci.setInsureeName(insurance.getFarmer().getName());
		ci.setSumInsured(insurance.getSumInsured());
		ClaimInsurance ci1 = (ClaimInsurance) claimInsuranceRepository.save(ci); 
		return ci1.getId();
	}
	
	
}
