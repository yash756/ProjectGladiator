package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.ClaimInsurance;

@Repository
public class ApproveInsuranceRepository extends GenericRepository {
	
	public List<ClaimInsurance> fetchClaims(){
		return entityManager
				.createQuery("select c from ClaimInsurance c")
				.getResultList();
	}

}
