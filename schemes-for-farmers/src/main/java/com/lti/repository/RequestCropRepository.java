package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Request;

@Repository
public class RequestCropRepository extends GenericRepository{

	public Request getcropbydetails(int farmerid, int quantity, double price) {

		Request request = (Request) entityManager
				.createQuery("select r from Request r where r.farmer.id = :fid and r.quantity = :q and r.basePrice = :bp")
				.setParameter("fid", farmerid).setParameter("q", quantity).setParameter("bp", price).getSingleResult();
		return request;
	}
	
	public boolean isCropPresent(int id, float f, double price, String name) {

		return (Long) 
				entityManager.createQuery(
				"select count(r.requestId) from Request r where r.farmer.id = :fid and r.quantity = :q and r.basePrice = :bp  and r.cropName= :n")
				.setParameter("fid", id).setParameter("q", f).setParameter("bp", price)
				.setParameter("n", name).getSingleResult() == 1 ? true : false;

	}

	public List<Request> fetchRequestCrop(){
		return
				entityManager
				.createQuery("select r from Request r ")
				.getResultList();
	}
}
