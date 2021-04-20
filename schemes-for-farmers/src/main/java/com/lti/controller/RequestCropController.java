package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.Status;
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


	
}
