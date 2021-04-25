package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.SoldCropDetails;
import com.lti.entity.Bidder;
import com.lti.entity.MarketPlace;

@Repository
public class BidderRepository extends GenericRepository {
	
	public void save(Bidder bidder) {
		 entityManager.merge(bidder);
	}
	
	public Bidder findbyId(int id) {
		return entityManager.find(Bidder.class, id);
	} 
	
	
}

