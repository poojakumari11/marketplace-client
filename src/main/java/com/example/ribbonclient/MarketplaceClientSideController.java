package com.example.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MarketplaceClientSideController {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;


	@PostMapping("/add-project")
	public String addProject() {
		String randomString = this.restTemplate.getForObject("http://server/backend", String.class);
		return "Server Response :: " + randomString;
	}

	@GetMapping("/project-details")
	public String getProject() {
		String randomString = this.restTemplate.getForObject("http://server/backend", String.class);
		return "Server Response :: " + randomString;
	}
}
