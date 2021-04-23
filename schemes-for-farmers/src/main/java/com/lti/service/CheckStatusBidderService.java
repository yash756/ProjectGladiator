package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.repository.CheckStatusBidderRepository;

@Service
@Transactional
public class CheckStatusBidderService {
	
	@Autowired
	private CheckStatusBidderRepository checkStatusBidderRepository;
	
	//from client bidder object will come
	//this function will return all the bids placed by a bidder
	public List<Bid> getPlacedBids(Bidder bidder){
		List<Bid> list = checkStatusBidderRepository.fetchbids(bidder.getBidderId());
		//List<Bid> list = checkStatusBidderRepository.fetchbids(12);
		return list;
	}

}
