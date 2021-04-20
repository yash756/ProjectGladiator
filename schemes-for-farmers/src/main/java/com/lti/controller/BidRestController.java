package com.lti.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BidStatus;
import com.lti.dto.MaxBid;
import com.lti.dto.Status;
import com.lti.entity.Bid;
import com.lti.entity.MarketPlace;
import com.lti.exception.BidServiceException;
import com.lti.exception.CropServiceException;
import com.lti.service.BidService;




@RestController
@CrossOrigin
public class BidRestController {

	@Autowired
	private BidService bidService;

	@PostMapping("/placeBids")
	public BidStatus placebid(@RequestBody Bid bid) {
		try {
			
			//bidService.savebid(bid);
			Bid bid1 = bidService.savebid(bid);
			BidStatus status = new BidStatus();
			status.setBidId(bid1.getBidId());
			status.setStatus(true);
			status.setMessage("Bids PLaced suucessfully");

			return status;

		} catch (BidServiceException e) {

			BidStatus status = new BidStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;

		}
	}
	
	@GetMapping("/fetchCropFromMarketPlace")
	public MarketPlace fetch(@RequestParam("itemNo") int itemNo) {
		MarketPlace marketPlace = bidService.getCropDetails(itemNo);
		return marketPlace;
	}
	
	@GetMapping("/fetchMarketPlace")
	public List<MarketPlace> viewMarketPlace() {
		List<MarketPlace> marketPlace = bidService.getMarketPlaceCrops();
		return marketPlace;
	}

	
}
