package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/sample/*")
@Controller
@Slf4j
public class SampleController {
	@GetMapping("/all")
	public void doAll() {
		log.info("모든 사람에게 접근 권한이 있음");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("멤버에게만 접근 권한이 있음");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("관리자만 접근");
	}
}