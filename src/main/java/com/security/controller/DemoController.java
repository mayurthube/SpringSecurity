package com.security.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("Demo")
public class DemoController {
	private static final Logger logger = LogManager.getLogger(DemoController.class);
	// RESTful API methods for Retrieval operations
		@GetMapping("/homePage")
		public  String homePage() {
			logger.info("--homePage");
		    return "home.jsp";
		}
		
		@GetMapping("/details")
		public  String details() {
			logger.info("--details");
		    return "details";
		}
}
