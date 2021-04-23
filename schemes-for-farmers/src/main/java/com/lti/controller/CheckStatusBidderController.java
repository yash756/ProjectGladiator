package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.service.CheckStatusBidderService;

@RestController
@CrossOrigin
public class CheckStatusBidderController {
	
	@Autowired
	private CheckStatusBidderService checkStatusBidderService;
	
	@PostMapping("/checkStatusOfBids")
	public List<Bid> viewStatus(@RequestBody Bidder bidder){
		List<Bid> statusList = checkStatusBidderService.getPlacedBids(bidder);
		return statusList;
	}

}
