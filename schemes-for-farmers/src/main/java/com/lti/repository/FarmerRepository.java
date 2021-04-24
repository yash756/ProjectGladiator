package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.SoldCropDetails;
import com.lti.entity.Bid;
import com.lti.entity.Farmer;
import com.lti.entity.Request;

@Repository
public class FarmerRepository extends GenericRepository{

	public boolean isFarmerPresent(String email) {
		return (Long) 
				 entityManager
				 .createQuery("select count(f.id) from Farmer f where f.email = :em")
				 .setParameter("em",email)
				 .getSingleResult() == 1 ? true : false;
	}
	
	public int fetchByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select f.id from Farmer f where f.email = :em and f.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	public Farmer findbyId(int id) {
		return entityManager.find(Farmer.class, id);
	}
	
public List<SoldCropDetails> fetchSoldCrop(int farmerId){
		
		return
				entityManager
				//.createQuery("select  m.cropName, m.quantity, b.bidAmount  from MarketPlace")
				.createQuery("select new com.lti.dto.SoldCropDetails( m.itemNo,m.cropName,m.quantity,m.basePrice,max(b.bidAmount),r.requestId ) "
						+ "from MarketPlace m JOIN m.bids b JOIN m.request r "
						+ "WHERE m.status='sold' and r.farmer.id = :id  "
						+ "GROUP BY m.itemNo,m.cropName,m.quantity,m.basePrice,r.requestId")
				.setParameter("id", farmerId)
				.getResultList();
	}


	
}


