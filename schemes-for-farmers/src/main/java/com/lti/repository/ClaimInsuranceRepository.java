package com.lti.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Insurance;

@Repository
public class ClaimInsuranceRepository extends GenericRepository {
	
	public boolean appliedForClaim(int policyNo) {
		String jpql = "select count(ci.id) from ClaimInsurance ci where ci.insurance.policyNo = :policyNo";
		Query query = entityManager.createQuery(jpql).setParameter("policyNo", policyNo);
		Long flag = (Long) query.getSingleResult();
		if (flag == 1)
			return true;
		else
			return false;
	}
	
	public int fetchInsurance(int farmerId) {
		String jpql = "select i.policyNo from Insurance i where i.farmer.id = :farmerId";
		Query query = entityManager.createQuery(jpql).setParameter("farmerId", farmerId);
		return  (int) query.getSingleResult();
	}
	
}