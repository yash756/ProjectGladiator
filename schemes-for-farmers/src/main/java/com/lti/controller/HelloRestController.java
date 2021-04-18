package com.lti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloRestController {
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {
		return "welcome to Spring MVC";
	}

}
