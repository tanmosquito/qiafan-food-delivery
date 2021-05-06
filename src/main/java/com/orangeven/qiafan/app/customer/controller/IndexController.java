package com.orangeven.qiafan.app.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("customerIndexController")
@RequestMapping("/customer")
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "/customer.html";
	}
}
