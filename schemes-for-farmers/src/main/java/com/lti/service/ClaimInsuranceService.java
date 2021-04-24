package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ClaimInsurance;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.exception.ClaimInsuranceServiceException;
import com.lti.exception.InsuranceServiceException;
import com.lti.repository.ClaimInsuranceRepository;
import com.lti.repository.InsuranceRepository;

@Service
@Transactional
public class ClaimInsuranceService {
	
	@Autowired
	private ClaimInsuranceRepository claimInsuranceRepository;
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	//function to claim insurance
	//from client only farmerId, loss date and cause of loss will come
	public int claim(ClaimInsurance ci) {
		
		Farmer farmer = (Farmer) claimInsuranceRepository.fetch(Farmer.class, ci.getFarmer().getId());
		
		//if-else to check if even applied for insurance before claiming
		if(insuranceRepository.appliedForInsurance(farmer.getId())) {
			int id = claimInsuranceRepository.fetchInsurance(farmer.getId());
			Insurance insurance = claimInsuranceRepository.fetch(Insurance.class, id);
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
		else {
			throw new ClaimInsuranceServiceException("first apply for insurance");
		}
	}
	
	public Insurance fetchDetails(int id) {
		int iid = claimInsuranceRepository.fetchInsurance(id);
		Insurance insurance = claimInsuranceRepository.fetch(Insurance.class, iid);
		return insurance;
		
	}
	
	
}
