package com.lti.repository;
import java.time.*;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.lti.entity.MarketPlace;
/*
 * Fetching all available crops that are open for bidding process
 */

@Repository
public class MarketPlaceRepository extends GenericRepository {
	
	public MarketPlace findbyId(int id) {
		return entityManager.find(MarketPlace.class, id);
	} 
	
	public List<MarketPlace> getCrops(){
		return entityManager
				.createQuery
				("select m.cropName, m.cropType, m.id, m.basePrice from MarketPlace m where m.status = :st and m.expiry >:dt")//select m from MarketPlace m where m.status = :st and m.expiryDate> :dt
			    .setParameter("st", "available")
				.setParameter("dt",LocalDateTime.now()).getResultList();
	}
	
	
}
