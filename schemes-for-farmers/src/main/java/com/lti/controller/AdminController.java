package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.entity.Request;
import com.lti.service.FarmerService;
import com.lti.service.RequestCropService;

public class AdminController {

	@Autowired
	private RequestCropService requestCropService;
	
	@GetMapping(path="/viewCrops")
	public List<Request> viewAll() {
		List<Request> requestList = requestCropService.getRequestedCrops();
		return requestList;
	}
	
}
