package com.green.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.service.BuyService;
import com.green.service.SignService;

import com.green.vo.BuyVO;

import com.green.vo.SignVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/exam/*")
@Slf4j
public class SignController {
	@Setter(onMethod_=@Autowired)
	SignService service;
	
	@Setter(onMethod_=@Autowired)
	BuyService bservice;
	
	@GetMapping("/signup")
	public void signup() {
		System.out.println(" 회원가입 페이지 ");
	}

	@PostMapping("/signup")
	public String postSignup(SignVO vo) {
		System.out.println("로그인 성공");
		service.signup(vo);
		
		return "redirect:signup";
	}
	@GetMapping("/login")
	public void login() {
		log.info("login page");
	}
	
	@RequestMapping(value = "/exam/buy",  method = RequestMethod.GET)
	public String loginform(BuyVO vo, SignVO svo, HttpServletRequest request) {
		log.info("1) 로그인 고객 정보 ");
		HttpSession session = request.getSession();
		vo.setBnum((int)(Math.random()*10000)+"-"+(int)(Math.random()*10000));
		session.setAttribute("buy", vo);
		session.setAttribute("list", service.login(svo));
		return "/exam/buy";
	}
	
	@PostMapping("/buy")
	public String buy(BuyVO vo) {
		System.out.println("제품 구매 완료");
		bservice.somebuy(vo);		
		return "/exam/buy";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("1) 구매 목록 조회" );
		model.addAttribute("blist", bservice.buyList());
	}
	@PostMapping("/takeback")
	public String takeback(@RequestParam("bnum") String bnum) {
		bservice.takeBack(bnum);
		
		return "redirect:/exam/list";
	}
}
