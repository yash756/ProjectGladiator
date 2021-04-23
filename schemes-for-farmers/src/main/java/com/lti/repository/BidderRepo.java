package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

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
	
	
}
