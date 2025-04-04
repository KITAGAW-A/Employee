package com.example.emplyeesreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/company")
	public String companyOverview() {
		return "company/overview";
	}
	
	@GetMapping("/organization")
	public String organizationChart() {
		return "company/organization";
	}
	
}
