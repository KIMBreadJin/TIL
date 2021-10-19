package com.green.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CommonController {
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("접근 제한 : " + auth);
		model.addAttribute("msg","접근 거부 되었습니다. 다시 접근해주세요");
	}
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);
		if(error != null) model.addAttribute("error", "로그인 에러이므로 계정을 확인해 주세요");
		else if(logout != null) model.addAttribute("logout", "로그아웃 되었습니다.");
	}
	@GetMapping("/customLogout")
	public void logoutGet() {
		log.info("커스텀 로그아웃");
	}

	  
}
