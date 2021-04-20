package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.BidsDto;
import com.lti.dto.PlaceBidDto;
import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.entity.MarketPlace;
import com.lti.entity.Request;
import com.lti.exception.BidServiceException;
import com.lti.exception.CropServiceException;
import com.lti.exception.RequestCropServiceException;
import com.lti.repository.BidRepo;
import com.lti.repository.BidderRepository;
import com.lti.repository.FarmerRepository;
import com.lti.repository.MarketPlaceRepository;
import com.lti.repository.RequestRepository;

@Service
@Transactional
public class BidService {
	
	@Autowired
	private BidderRepository bidderRepo;
	
	@Autowired
	private BidRepo bidRepo;
	
	@Autowired
	private RequestRepository reqRepo;
	
	@Autowired
	private MarketPlaceRepository markRepo;
	
	//@Autowired
	//private FarmerRepository farmRepo;
	
	/*public int savebid(PlaceBidDto placebiddto) {
		try {
				Bid bid = new Bid();

				//Request request = reqRepo.findbyId(placebiddto.getRequestId());
				
				MarketPlace marketPlace = markRepo.findbyId(placebiddto.getItemNo());

				Bidder bidder = bidderRepo.findbyId(placebiddto.getBidderId());

				bid.setMarketplace(marketPlace);
				bid.setBidder(bidder);

				double currentbid = bidRepo.maxbid(placebiddto.getItemNo());

				if (currentbid == 0.0) {
					currentbid = marketPlace.getBasePrice();

				if (currentbid + 99.9 > placebiddto.getBidAmount()) {

					throw new BidServiceException("Bid amount should be atleast 100 greater than current bid amount");
				}
				bid.setBidAmount(placebiddto.getBidAmount());

				bidRepo.save(bid);
	
			}	
				return bid.getBidId();

		}catch (EmptyResultDataAccessException e) {
				throw new BidServiceException("Failed to add bid");
			}
		
	}*/
	
	public int savebid(Bid bid) {				
			try {
			
				Bidder bidder = bidderRepo.findbyId(bid.getBidder().getBidderId());
				MarketPlace marketPlace = markRepo.findbyId(bid.getMarketplace().getItemNo());
				
				double currentbid = bidRepo.maxbid(bid.getMarketplace().getItemNo());

				if (currentbid == 0.0) {
					currentbid = marketPlace.getBasePrice();

				if (currentbid + 99.9 > bid.getBidAmount()) {

					throw new BidServiceException("Bid amount should be atleast 100 greater than current bid amount");
				}
				bid.setBidAmount(bid.getBidAmount());

				bid.setBidder(bidder);
				bid.setMarketplace(marketPlace);
				bidRepo.save(bid);
	
			}	
				return bid.getBidId();

		}catch (EmptyResultDataAccessException e) {
				throw new BidServiceException("Failed to add bid");
			}
		
	}
	
	public double getBid(int id) {
		try {
			double amount = bidRepo.maxbid(id);
			System.out.println(amount);
			if (amount == 0) {
				amount = reqRepo.getBasePrice(id);
			}
			if (amount == 0) {

				throw new CropServiceException("Crop not found");
			}
			return amount;

		} catch (EmptyResultDataAccessException e) {
			throw new CropServiceException("No Bid available");
		}
	}
	

}
