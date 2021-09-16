package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.mapper.TireMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/tire/*")
@Slf4j
public class TireController {
	@Setter(onMethod_=@Autowired)
	TireMapper mapper;
	

	@RequestMapping("/a")
	public String basic() {
		log.info("컨트롤러 .........");
		return "/sample/a";
	}
	
}
