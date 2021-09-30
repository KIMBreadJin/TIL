package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.service.ManageService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/person/*")
@Slf4j
public class ManageController {
	@Setter(onMethod_=@Autowired)
	ManageService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("1) 가족 리스트 조회" );
		model.addAttribute("list", service.getList());
	}
	@RequestMapping(value = "/person/count",  method = RequestMethod.POST)
	public String conut(String address, Model model) {
		log.info("1) 가족수 ");
		model.addAttribute("count", service.getCount(address));
		model.addAttribute("cnt", address);
		return "/person/count";
	}
	@GetMapping("/second")
	public void second(Model model) {
		log.info("1) 지역별 총인원 순서" );
		model.addAttribute("sec", service.secondList());
	}
}
