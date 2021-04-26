package com.lti.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bid;
import com.lti.entity.MarketPlace;

@Repository
public class BidRepo extends GenericRepository{
	
	
	public double maxbid(int id) {

		return (double) entityManager.createQuery("select COALESCE(MAX(b.bidAmount),0) from Bid b where b.marketPlace.itemNo = :cid")
				.setParameter("cid", id).getSingleResult();
	}
	
	public List<MarketPlace> fetchMarketPlaceCrops(){
		return entityManager
				.createQuery("select m from MarketPlace m where m.status = :st")
				//select m from MarketPlace m where m.status = :st and m.expiryDate> :dt
				.setParameter("st", "available")
				//.setParameter("dt",LocalDateTime.now())
				.getResultList();
		
	}
	
	
}