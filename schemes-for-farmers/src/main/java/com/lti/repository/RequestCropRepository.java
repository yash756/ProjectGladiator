package com.lti.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.MarketPlace;
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
				//.createQuery("select r from Request r ")
				.createQuery("select r from Request r LEFT OUTER JOIN r.marketplace m ")
				.getResultList();
	}
	
	public List<MarketPlace> fetchMarketCrop(){
		LocalDateTime now = LocalDateTime.now();
	
		return
				entityManager
				.createQuery("select m from MarketPlace m where m.endTime < :now and m.status = :s")
//				.createQuery("select m from Bid b INNER JOIN b.marketPlace m  where (b.bidAmount is not null) and b.itemNo = :item  and m.endTime < :now and m.status = :s")
				.setParameter("now", now).setParameter("s","available")//.setParameter("item", now)
				.getResultList();
	}
	
	public boolean checkIfAddedToMarket(int requestId) {
		String jpql = "select count(m.itemNo) from MarketPlace m where m.request.requestId= :requestId";
		Query query = entityManager.createQuery(jpql).setParameter("requestId", requestId);
		Long flag = (Long) query.getSingleResult();
		if(flag == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
