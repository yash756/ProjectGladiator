package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.BidsDto;
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
	
	public Bid savebid(Bid bid) {				
			try {
			
				Bidder bidder = bidderRepo.findbyId(bid.getBidder().getBidderId());

				MarketPlace marketPlace = markRepo.findbyId(bid.getMarketPlace().getItemNo());
				
				double currentbid = bidRepo.maxbid(bid.getMarketPlace().getItemNo());

				if (currentbid == 0.0) 
					currentbid = marketPlace.getBasePrice();
				
				else if (currentbid + 99.9 > bid.getBidAmount()) {

					throw new BidServiceException("Bid amount should be atleast 100 greater than current bid amount");
				}
				bid.setBidAmount(bid.getBidAmount());
				bid.setBidder(bidder);
				bid.setMarketPlace(marketPlace);
				bid.setDateOfBid(LocalDate.now());

				bidRepo.save(bid);
	
				
				return bid;

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
	
	public MarketPlace getCropDetails(int itemNo) {
		
		MarketPlace mark = bidRepo.fetch(MarketPlace.class, itemNo);
		
		mark.setMaxBid(bidRepo.maxbid(itemNo));
		return  mark;
	}

	public List<MarketPlace> getMarketPlaceCrops() {
		List<MarketPlace> list = bidRepo.fetchMarketPlaceCrops();
//		return list;
		
//		for(MarketPlace mark: list) {
//			mark.setMaxBid(bidRepo.maxbid(mark.getItemNo()));	
			//Need to return this as a list
//			System.out.println(mark.getCropName());
			//List<MarketPlace> result = mark.list();
//		}
		
		return list;
	}
	
	}
