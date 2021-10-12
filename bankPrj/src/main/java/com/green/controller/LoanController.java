package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.service.BankService;
import com.green.vo.FreeVO;
import com.green.vo.LoanVO;
import com.green.vo.LoginVO;

import lombok.Setter;

@Controller
@RequestMapping("/loan")
public class LoanController {
	
	@Setter(onMethod_=@Autowired)
	private BankService service;
	
	@GetMapping("/register")
	public String freeRegister(Model model , String loan_name) {//로그인 된 상태에 여기로 이동함 
		//LoginController에서 redirect 한 값이 여기 login_name에 실려옴 
		System.out.println("대출 등록 컨틀롤러 get : " +loan_name);
		LoanVO vo = new LoanVO();
		if(service.getLoanWithName(loan_name) == null) {//거래 내역이 없을 경우
			//System.out.println();
			LoginVO loginVO = service.getLoginOneWithName(loan_name);
			FreeVO fvo = service.getListOneWithName(loan_name);
			vo.setLoan_balance(fvo.getFree_balance()*10);//자유입출금 금액의 10배 대출 가능액 
			vo.setLoan_deposit(0f);
			vo.setLoan_withdraw(0f);
			vo.setLoan_name(loan_name);
			vo.setLoan_password(loginVO.getLogin_password());
			vo.setLoan_serial("L20211012_0001");
			service.insertLoan(vo);
			model.addAttribute("list", service.getLoanWithName(loan_name));
		}
		model.addAttribute("list", service.getLoanWithName(loan_name));//추가 
		return "/loan/register";
	}
	@PostMapping("/register")
	public String loanResterPost(LoanVO vo) {
		LoanVO vo2 = service.getLoanWithName(vo.getLoan_name());
		if(vo.getLoan_deposit()==0) { //대출
			vo2.setLoan_withdraw(vo.getLoan_withdraw());
			vo2.setLoan_balance(vo2.getLoan_balance()-vo.getLoan_withdraw());
		} else if(vo.getLoan_withdraw()==0) {//상환
			vo2.setLoan_deposit(vo.getLoan_deposit());
			vo2.setLoan_balance(vo.getLoan_balance()+vo.getLoan_deposit());
		}
		vo2.setLoan_serial("L20211012_0001"+ (service.getMaxId()+1));
		service.insertLoan(vo2);
		return "redirect:/loan/getAll";
	}
	@GetMapping("/getAll")
	public String getAllLoan(Model model) {
		model.addAttribute("list",service.getListLoan());
		return "/loan/getAll";
	}

}
