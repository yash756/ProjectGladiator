package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bid;

@Repository
public class CheckStatusBidderRepository extends GenericRepository {
	
	public List<Bid> fetchbids(int bidderId){
		return entityManager
				.createQuery("select b from Bid B where b.bidder.bidderId = :bidderId" )
				.getResultList();
	}
}
