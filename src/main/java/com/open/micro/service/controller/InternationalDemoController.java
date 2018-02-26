package com.open.micro.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.micro.service.service.LocaleMessageService;

@RestController
@RequestMapping("/in")
public class InternationalDemoController {

	@Autowired private LocaleMessageService localeMessageService;
	
	@RequestMapping("/lang")
	public String lang() {
		return localeMessageService.getMessage("test.test");
	}
	
}
