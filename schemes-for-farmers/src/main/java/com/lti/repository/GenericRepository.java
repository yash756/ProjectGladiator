package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.entity.MarketPlace;

//@Component
@Repository //recommended for Dao classes
public class GenericRepository { //another name for Dao
	
	@PersistenceContext
	public EntityManager entityManager;
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
	
	public <E> E fetch(Class<E> clazz, Object pk) {
		E e = entityManager.find(clazz, pk);
		return e;
	}
	
//	@PersistenceContext
//	public EntityManager em;
//	
//	public void fetchlist() {
//		Query query=em.createQuery("select m from MarketPlace m where m.status = :st")
//				//select m from MarketPlace m where m.status = :st and m.expiryDate> :dt
//				.setParameter("st", "open");
//		List <MarketPlace> marketplace = query.getResultList();
//	};

}
