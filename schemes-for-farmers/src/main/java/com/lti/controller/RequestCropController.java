package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.Status;
import com.lti.entity.MarketPlace;
import com.lti.entity.Request;
import com.lti.exception.RequestCropServiceException;
import com.lti.service.RequestCropService;

@RestController
@CrossOrigin
public class RequestCropController {

	@Autowired
	private RequestCropService requestCropService;

	@PostMapping(path = "/requestCrop")
	public Status register(@RequestBody Request request) {
		try {
			requestCropService.register(request);
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Crop added Successfully");
			
			return status;
		} catch (RequestCropServiceException e) {

			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;

		}
	}

	@GetMapping(path="/viewCrops")
	public List<Request> viewAll() {
		List<Request> requestList = requestCropService.getRequestedCrops();
		return requestList;
	}
	
	@GetMapping(path="/addToMarketPlace")
	public Status addToMarket(@RequestParam("requestId") int requestId) {
		try {
			int id = requestCropService.addToMarket(requestId);
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Crop added to market Successfully");
			status.setId(id);
			return status;
		} catch (RequestCropServiceException e) {

			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;

		}
	}
	
	@GetMapping(path="/viewAdminMarket")
	public List<MarketPlace> viewAdminMarket() {
		List<MarketPlace> requestList = requestCropService.getMarketCrops();
		return requestList;
	}
	
	@GetMapping(path="/approveAsSold")
	public Status approveAsSold(@RequestParam("itemNo") int itemNo) {
		try {
			int id = requestCropService.approveAsSold(itemNo);
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Crop Sold");
			status.setId(id);
			return status;
		} catch (RequestCropServiceException e) {

			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;

		}
	}
	
	@GetMapping(path="/approveAsUnsold")
	public Status approveAsUnsold(@RequestParam("itemNo") int itemNo) {
		try {
			int id = requestCropService.approveAsUnsold(itemNo);
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Crop Unsold");
			status.setId(id);
			return status;
		} catch (RequestCropServiceException e) {

			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;

		}
	}
	
}
