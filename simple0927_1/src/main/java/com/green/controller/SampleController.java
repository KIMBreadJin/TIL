package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	
	@RequestMapping("/in")
	public String insert() {
		return "/sample/in";
	}
}
