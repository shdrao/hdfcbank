package com.capgemini.hdfcbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@RequestMapping("/h")
	public String saydHello() {
		return "index";
	}

}
