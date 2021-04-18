package com.lti.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class InsuranceRepository extends GenericRepository {
	
	public boolean appliedForInsurance(int farmerId) {
		
		String jpql = "select count(i.policyNo) from Insurance i where i.farmer.id = :farmerId";
		Query query = entityManager.createQuery(jpql).setParameter("farmerId", farmerId);
		Long flag = (Long) query.getSingleResult();
		if (flag == 1)
			return true;
		else
			return false;
	}
	
}
