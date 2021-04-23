package com.lti.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lti.entity.Farmer;
import com.lti.entity.MarketPlace;
import com.lti.entity.Request;
import com.lti.exception.RequestCropServiceException;
import com.lti.repository.FarmerRepository;
import com.lti.repository.MarketPlaceRepository;
import com.lti.repository.RequestCropRepository;

@Service
@Transactional
public class RequestCropService {

	@Autowired
	private RequestCropRepository requestCropRepo;
	
	@Autowired
	private FarmerRepository farmerRepo;
	
	@Autowired
	private MarketPlaceRepository marketRepo;

	
	public void register(Request request) {
		
		try {
		
			Farmer farmer = farmerRepo.findbyId(request.getFarmer().getId());
			
//			long daysBetween = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
//			if (daysBetween > 30) {
//				throw new RequestCropServiceException("The bid period cannot be greater than 30 days");
//			}
			if (requestCropRepo.isCropPresent(request.getFarmer().getId(), request.getQuantity(), request.getBasePrice(),
					request.getCropName())) {
				throw new RequestCropServiceException("Similar request has been made already");
			}
			request.setFarmer(farmer);

			requestCropRepo.save(request);

		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			throw new RequestCropServiceException("Only a registered farmer can add crop");
		}

	}
	
	public List<Request> getRequestedCrops() {
		List<Request> list = requestCropRepo.fetchRequestCrop();
		return list;

}
	public int addToMarket(int requestId) {
		System.out.println("check"+requestId);
//		Request r = new Request();
		Request request =  requestCropRepo.fetch(Request.class,requestId);
		LocalDateTime start = LocalDateTime.now();
		double bidCuttOffTime = request.getBidCutoffTime();
		LocalDateTime end = start.plusHours((long) bidCuttOffTime);
		
		MarketPlace m = new MarketPlace();
		
//		List<Request> list = farmerRepo.fetchRequestCrop();
//		for(Request req : list) {
			m.setCropName(request.getCropName());
			m.setCropType(request.getCropType());
			m.setBasePrice(request.getBasePrice());
			m.setStatus("unsold");
			m.setQuantity(request.getQuantity());
			m.setStartTime(start);
			m.setEndTime(end);
			m.setRequest(request);
			marketRepo.save(m);
			
			return m.getItemNo();
		//}
	}
	
	public List<MarketPlace> getMarketCrops() {
		List<MarketPlace> list = requestCropRepo.fetchMarketCrop();
		return list;

}
	
	public int approveAsSold(int itemNo) {
//		Request r = new Request();
		MarketPlace marketPlace =  requestCropRepo.fetch(MarketPlace.class,itemNo);
		marketPlace.setStatus("sold");
		marketRepo.save(marketPlace);
			
			return marketPlace.getItemNo();
		//}
	}
	

}
