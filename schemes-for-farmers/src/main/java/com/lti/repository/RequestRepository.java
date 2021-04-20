package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.Request;


@Repository
public class RequestRepository extends GenericRepository {
	
	public Request findbyId(int id) {
		return entityManager.find(Request.class, id);
	}
	
	public double getBasePrice(int id) {
		return (Double) entityManager.createQuery("select b.basePrice from MarketPlace b where b.id = :cid")
				.setParameter("cid", id).getSingleResult();
	}
}
