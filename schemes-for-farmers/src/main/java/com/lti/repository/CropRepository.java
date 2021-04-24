package com.lti.repository;

import java.util.List;

import com.lti.entity.MarketPlace;



public class CropRepository extends GenericRepository{

	public List<MarketPlace> findSoldCropsbyFarmerId(int id) {

		List crops = entityManager.createQuery("select m from MarketPlace m where m.user.id = :cid and m.status = 'Sold'")
				.setParameter("cid", id).getResultList();
		return crops;
	}

}
