package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bid;

@Repository
public class BidRepo extends GenericRepository{
	
	
	@Transactional
	public void save(Bid bid) {
		entityManager.merge(bid);

	}
	
	@Transactional
	public double maxbid(int id) {
		return (double) entityManager.createQuery("select MAX(b.bidAmount) from Bid b where b.marketPlace.itemNo = :cid")
				.setParameter("cid", id).getSingleResult();
	}
	
}
