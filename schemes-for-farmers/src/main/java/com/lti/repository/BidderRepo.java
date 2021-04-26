package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.BroughtCropDetails;
import com.lti.dto.SoldCropDetails;
import com.lti.entity.Farmer;
import com.lti.entity.Request;

@Repository
public class BidderRepo extends GenericRepository{

	public boolean isBidderPresent(String email) {
		return (Long) 
				 entityManager
				 .createQuery("select count(b.bidderId) from Bidder b where b.emailId = :em")
				 .setParameter("em",email)
				 .getSingleResult() == 1 ? true : false;
	}
	
	public int fetchByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select b.bidderId from Bidder b where b.emailId = :em and b.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
public List<BroughtCropDetails> fetchBroughtCrop(int bidderId){
		
		return
				entityManager
				//.createQuery("select  m.cropName, m.quantity, b.bidAmount  from MarketPlace")
				.createQuery("select new com.lti.dto.BroughtCropDetails(m.itemNo,m.basePrice,m.cropName,m.quantity, COALESCE(max(b.bidAmount),0)) FROM	MarketPlace m INNER JOIN m.bids b WHERE	b.bidder.bidderId = :id and  COALESCE(max(b.bidAmount),0)= (select MAX(b.bidAmount) from Bid b where b.marketPlace.itemNo = m.itemNo ) GROUP BY m.itemNo,m.basePrice,m.cropName,m.quantity")
				.setParameter("id", bidderId)
				.getResultList();
		
	}
}
