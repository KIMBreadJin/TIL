package com.green.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.service.BankService;
import com.green.service.LoanService;
import com.green.vo.BankVO;
import com.green.vo.LoanVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/bank/*")
@Slf4j
public class BankController {
	@Setter(onMethod_=@Autowired)
	BankService service;
	
	@Setter(onMethod_=@Autowired)
	LoanService lservice;
	
	@GetMapping("/login")
	public void login() {
		log.info("login page");
	}
	@GetMapping("/list")
	public String login2() {
		return "/bank/list";
	}
	@GetMapping("/get")
	public void get() {	
	}

	@RequestMapping(value = "/bank/list",  method = RequestMethod.POST)
	public String loginform(BankVO vo, LoanVO lvo, HttpServletRequest request) {
		log.info("1) 로그인 고객 정보 ");
		HttpSession session = request.getSession();
		session.setAttribute("list", service.login(vo));
		return "/bank/list";
	}
	
	@RequestMapping(value = "/bank/borrow",  method = RequestMethod.POST)
	public String borrowInfo(LoanVO vo, BankVO bvo, HttpServletRequest request) {
		log.info("1) 고객 대출 정보 ");
		HttpSession session = request.getSession();
		session.setAttribute("borw", lservice.info(vo));
	
		return "/bank/borrow";
	}

	@GetMapping("/insert")
	public String insertLoan(LoanVO vo,RedirectAttributes rttr) {
		lservice.insert(vo);
		return "redirect:list";
	}
	@PostMapping("/update")
	public String update(LoanVO vo, RedirectAttributes rttr) {	
		rttr.addAttribute("loan_withdraw", vo.getLoan_withdraw());
		rttr.addAttribute("lmoney",vo.getLmoney());
		rttr.addAttribute("free_id",vo.getFree_id());
		System.out.println(vo.getLoan_withdraw());
		System.out.println(vo.getLmoney());
		System.out.println(vo.getFree_id());
		lservice.update(vo);
		return "redirect:list";
	}
	@PostMapping("/deposit")
	public String deposit(BankVO vo, RedirectAttributes rttr) {	
		rttr.addAttribute("fdeposit", vo.getFdeposit());
		rttr.addAttribute("fmoney",vo.getFmoney());
		rttr.addAttribute("free_id",vo.getFree_id());
		System.out.println(vo.getFdeposit());
		System.out.println(vo.getFmoney());
		System.out.println(vo.getFree_id());
		service.deposit(vo);
		return "redirect:login";
	}
	@PostMapping("/withdraw")
	public String withdraw(BankVO vo, RedirectAttributes rttr) {	
		rttr.addAttribute("fwithdraw", vo.getFwithdraw());
		rttr.addAttribute("fmoney",vo.getFmoney());
		rttr.addAttribute("free_id",vo.getFree_id());
		service.withdraw(vo);
		return "redirect:login";
	}
}
