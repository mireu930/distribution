package com.distribution.app.ingredients;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	private final String uniqueId = UUID.randomUUID().toString();
	

	@GetMapping("/health")
	public String healthCheck() {
		return "Server ID: " + uniqueId;
	}
}
