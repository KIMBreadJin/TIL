package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.service.BankService;
import com.green.vo.LoginVO;

import lombok.Setter;

@Controller
@RequestMapping("/login/*")
public class LoginController {

	@Setter(onMethod_=@Autowired)
	BankService service;
	
	
	@GetMapping("/register")
	public String register() {
		return "/login/register";
	}
	@PostMapping("/register")
	public String registerPost(LoginVO vo,RedirectAttributes rttr) {
		try {
			Long max = service.getMaxId();//데이터가 없으면 null에 접근하므로 exception발생하여 
			vo.setLogin_serial("F20211012_000"+ (max+1)) ;
		} catch (Exception e) {
			vo.setLogin_serial("F20211012_0001");
		}
		System.out.println("컨트롤러에서 회원 등록시 post : vo " +vo);
		service.register(vo);//테이블에 적용 
		return "redirect:/login/login";//회원등록후 자동으로  login으로 이동하게함 
	}
	
	@GetMapping("/login")
	public String loginGet() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String loginPost(LoginVO vo,RedirectAttributes rttr) {
		LoginVO vo2 =  service.loginWithPWAndName(vo);
		String login_name = vo2.getLogin_name();
		System.out.println("테이블에서 가져온 정보: " +vo2);
		if(vo2==null) {//비밀번호가 다르면 error로 이동 
			return "error";
		}
		rttr.addAttribute("login_name",login_name);
		return "redirect:/free/register";//로그인이 잘되면  자유입 출금 거래 로 이동 
		//return null;
	}
	@GetMapping("/getAll")
	public String loginListAll(Model model) {
		model.addAttribute("list", service.getListLogin());
		return "/login/getAll";
	}
}
