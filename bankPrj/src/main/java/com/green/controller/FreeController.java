package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.service.BankService;
import com.green.vo.FreeVO;

import lombok.Setter;

@Controller
@RequestMapping("/free/*")
public class FreeController {

	@Setter(onMethod_=@Autowired)
	BankService service;
	@GetMapping("/list")
	public String freeList(String login_name,Model model) {//예금주별 전체 목록 
		List<FreeVO> list = service.getListWithName(login_name);
		model.addAttribute("login_name", login_name);
		model.addAttribute("list",list);
		return "/free/list";
	}
	@GetMapping("/getAll")
	public String freeListAll(String login_name,Model model) {//이름과 무관한 전체 목록
		model.addAttribute("list",service.getListFree());
		return "/free/getAll";
	}
	@GetMapping("/register")
	public String freeRegister(Model model , String login_name) {//로그인 된 상태에 여기로 이동함 
		//LoginController에서 redirect 한 값이 여기 login_name에 실려옴 
		if(service.getListOneWithName(login_name) == null) {//거래 내역이 없을 경우 
			FreeVO vo = new FreeVO();
			vo.setFree_balance(0f);
			vo.setFree_deposit(0f);
			vo.setFree_withdraw(0f);
			vo.setFree_loan("N");
			vo.setFree_name(login_name);
			vo.setFree_password(service.getLoginOneWithName(login_name).getLogin_password());
			vo.setFree_serial(service.getLoginOneWithName(login_name).getLogin_serial());
			service.insertFree(vo);
			model.addAttribute("list", service.getListOneWithName(login_name));
		}
		System.out.println("자유 입출금 거래 컨트롤러의 get Register " + login_name);
		model.addAttribute("list", service.getListOneWithName(login_name));
		return "free/register";
				
	}
	@PostMapping("/register")
	public String registerPost(FreeVO vo ,RedirectAttributes rttr) {
		FreeVO vo2 = service.getListOneWithName(vo.getFree_name());
		if(vo.getFree_deposit()==0) {//출금을 하면 실행 
			vo2.setFree_withdraw(vo.getFree_withdraw());
			vo2.setFree_balance(vo2.getFree_balance()- vo.getFree_withdraw());
		} else if(vo.getFree_withdraw() ==0) {//입금을 하면 실행 
			vo2.setFree_deposit(vo.getFree_deposit());
			vo2.setFree_balance(vo2.getFree_balance()+vo.getFree_deposit());
		}
		if(vo2.getFree_balance()>=500) vo2.setFree_loan("Y");
		else vo2.setFree_loan("N");
		service.insertFree(vo2);
		rttr.addAttribute("login_name",vo.getFree_name()); //추가 
		return "redirect:/free/list";
		//login => 한번 거래후 자동으로 이동 
	}
	
}
