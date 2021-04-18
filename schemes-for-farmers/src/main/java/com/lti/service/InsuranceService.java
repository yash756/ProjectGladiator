package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.repository.InsuranceRepository;

/**
 * This class will contain two methods.
 * One to calculate premiums and other to save the data in db. 
 * @author Yash
 *
 */
@Service
@Transactional
public class InsuranceService {
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	//function to calculate premium and total insured sum
	public Insurance calculatePremium(Insurance insurance) {
		
		Farmer farmer = (Farmer) insuranceRepository.fetch(Farmer.class, 83);
		
		List<String> commercialCrops = new ArrayList<String>();
		commercialCrops.add("jute");
		commercialCrops.add("cotton");
		commercialCrops.add("sugarcane");
		commercialCrops.add("tobacco");
		
		List<String> companies = new ArrayList<String>();
		companies.add("Agriculture Insurance Company");
		companies.add("Reliance General Insurance Co. Ltd.");
		companies.add("Bajaj Allianz");
		companies.add("HDFC ERGO General Insurance Co. Ltd.");
		companies.add("ICICI Lombard General Insurance Co. Ltd.");
		
		if (insurance.getSeason().toLowerCase().equals("rabi") && commercialCrops.contains(insurance.getCropName()) == false){
			//uniform premium rate of 1.5% of SI for rabi crops
			//sum insured from year 2020 is 42000 per hec.
			if (insurance.getYear().getYear() >= 2020) {
				
				insurance.setSumInsured(insurance.getArea() * 42000);
				insurance.setSharePremium((insurance.getSumInsured() * 15) / 1000);
				insurance.setPremium(insurance.getSumInsured() - insurance.getSharePremium());
				insurance.setInsuranceCompany(companies.get(new Random().nextInt(companies.size())));
				//new line test
				insurance.setFarmer(farmer);
				
			}
			//sum insured before year 2020 is 35000 per hec.
			else if(insurance.getYear().getYear() < 2020) {
				
				insurance.setSumInsured(insurance.getArea() * 35000);
				insurance.setSharePremium((insurance.getSumInsured() * 15) / 1000);
				insurance.setPremium(insurance.getSumInsured() - insurance.getSharePremium());
				insurance.setInsuranceCompany(companies.get(new Random().nextInt(companies.size())));
			}
		}
		
		else if(insurance.getSeason().toLowerCase().equals("kharif") && commercialCrops.contains(insurance.getCropName()) == false) {
			//uniform premium rate of 2% of SI for kharif crops
			//sum insured from year 2020 is 40000 per hec.
			if (insurance.getYear().getYear() >= 2020) {
				
				insurance.setSumInsured(insurance.getArea() * 40000);
				insurance.setSharePremium((insurance.getSumInsured() * 2) / 100);
				insurance.setPremium(insurance.getSumInsured() - insurance.getSharePremium());
				insurance.setInsuranceCompany(companies.get(new Random().nextInt(companies.size())));
				
			}
			//sum insured before year 2020 is 32000 per hec.
			else if(insurance.getYear().getYear() < 2020) {
				
				insurance.setSumInsured(insurance.getArea() * 32000);
				insurance.setSharePremium((insurance.getSumInsured() * 2) / 100);
				insurance.setPremium(insurance.getSumInsured() - insurance.getSharePremium());
				insurance.setInsuranceCompany(companies.get(new Random().nextInt(companies.size())));
				
			}
		}
		
		else if(commercialCrops.contains(insurance.getCropName())) {
			//uniform premium rates for commercial crops is 5%
			//sum insured is 40000 per hec
			insurance.setSumInsured(insurance.getArea() * 40000);
			insurance.setSharePremium((insurance.getSumInsured() * 5) / 100);
			insurance.setPremium(insurance.getSumInsured() - insurance.getSharePremium());
			insurance.setInsuranceCompany(companies.get(new Random().nextInt(companies.size())));

		}
		
		return insurance;
		
	}
	
	//function to save insurance data into DB
	public int applyForInsurance(Insurance insurance) {
		//add try-catch to check if already applied for insurance
		Insurance insuranceUpdated = (Insurance) insuranceRepository.save(calculatePremium(insurance));
		return insuranceUpdated.getPolicyNo();
		
	}
}



