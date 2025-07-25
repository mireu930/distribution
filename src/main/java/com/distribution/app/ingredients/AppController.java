package com.distribution.app.ingredients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/health")
	public String healthCheck() {
		return "success health check";
	}
}
