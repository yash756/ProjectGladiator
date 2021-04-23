package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lti.entity.Farmer;
import com.lti.entity.MarketPlace;
import com.lti.repository.MarketPlaceRepository;

@Service
@Transactional
public class MarketPlaceService {


//	MarketPlace market = (MarketPlace) markRepo.fetch(MarketPlace.class, MarketPlace.getId());
//	@GetMapping("/fetchMarketPlaceCrops")
//	List<String> mark = new ArrayList<String>();
//	cropName.set("Jute");
//	cropName.set("Cotton");
//	
//	//MarketPlace.set(MarketPlace);
//	return market;
//	
	@Autowired
	private MarketPlaceRepository markRepo;
	
public MarketPlace getCropDetails(int itemNo) {
		
		MarketPlace mark = markRepo.fetch(MarketPlace.class, itemNo);
		return  mark;
	}

public List<MarketPlace> getMarketPlaceCrops() {
	List<MarketPlace> list = markRepo.getCrops();
	return list;
}
}
