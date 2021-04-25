package com.lti.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.BroughtCropDetails;
import com.lti.dto.SoldCropDetails;
import com.lti.entity.Bidder;

import com.lti.exception.BidderServiceException;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.BidderRepo;



@Service
@Transactional
public class BidderService {
	
	@Autowired
	private BidderRepo bidderRepository;
	
	public int register(Bidder bidder){
		if(bidderRepository.isBidderPresent(bidder.getEmailId()))
			throw new BidderServiceException("Farmer already registered");
		else {	
				bidder.setPassword(Base64.getEncoder().encodeToString(bidder.getPassword().getBytes()));
				Bidder updatedBidder = (Bidder) bidderRepository.save(bidder);
				//code to send email to the Farmer on successful registration will be here
				return updatedBidder.getBidderId();
		}
	}
	
	public Bidder login(String email, String password) {
		try {
			password = Base64.getEncoder().encodeToString(password.getBytes());
			int id = bidderRepository.fetchByEmailAndPassword(email, password);
			Bidder bidder = bidderRepository.fetch(Bidder.class,id);
			return bidder;
		}
		catch(EmptyResultDataAccessException e) {
		//catch(NoResultException e) {
			throw new BidderServiceException("Invalid email/password");
		}
	}
	
	public List<BroughtCropDetails> getBroughtCrops(int bidderId) {
		List<BroughtCropDetails> list = bidderRepository.fetchBroughtCrop(bidderId);
		return list;

}

}
