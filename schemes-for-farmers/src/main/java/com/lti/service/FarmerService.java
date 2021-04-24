package com.lti.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.SoldCropDetails;
import com.lti.entity.Bid;
import com.lti.entity.Farmer;
import com.lti.entity.Request;
import com.lti.exception.FarmerServiceException;

import com.lti.repository.FarmerRepository;

@Service
@Transactional
public class FarmerService {
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	public int register(Farmer farmer){
		if(farmerRepository.isFarmerPresent(farmer.getEmail()))
			throw new FarmerServiceException("Farmer already registered");
		else {	
				farmer.setPassword(Base64.getEncoder().encodeToString(farmer.getPassword().getBytes()));
				Farmer updatedFarmer = (Farmer) farmerRepository.save(farmer);
				//code to send email to the Farmer on successful registration will be here
				return updatedFarmer.getId();
		}
	}
	
	public Farmer login(String email, String password) {
		try {
			password = Base64.getEncoder().encodeToString(password.getBytes());
			int id = farmerRepository.fetchByEmailAndPassword(email, password);
			Farmer farmer = farmerRepository.fetch(Farmer.class,id);
			return farmer;
		}
		catch(EmptyResultDataAccessException e) {
		//catch(NoResultException e) {
			throw new FarmerServiceException("Invalid email/password");
		}
	}
	
	public List<SoldCropDetails> getSoldCrops(int farmerId) {
		List<SoldCropDetails> list = farmerRepository.fetchSoldCrop(farmerId);
		return list;

}

}
