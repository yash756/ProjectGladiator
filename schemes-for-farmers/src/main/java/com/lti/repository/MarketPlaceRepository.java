package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.MarketPlace;
import com.lti.entity.Request;

@Repository
public class MarketPlaceRepository extends GenericRepository {
	
	public MarketPlace findbyId(int id) {
		return entityManager.find(MarketPlace.class, id);
	} 
	
	
}
