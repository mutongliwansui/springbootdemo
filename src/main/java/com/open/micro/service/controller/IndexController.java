package com.open.micro.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		return "I am live";
	}
}
