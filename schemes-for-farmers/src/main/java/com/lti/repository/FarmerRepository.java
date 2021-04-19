package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.Farmer;

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
}
