package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.mapper.GreenMapper;
import com.green.vo.Green;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	@Setter(onMethod_=@Autowired)
	GreenMapper mapper;
	
	@RequestMapping("/a")
	public String basic() {
		log.info("여기는 컨트롤러 basic1..................");
		return "/sample/g";
	}
	
	@RequestMapping("/b")
	public String basic1(Green vo, Model model) {
		List<Green> vo1 = mapper.getList();
		//log.info(" " + vo.getEng() + " " + vo.getKor() +" " +vo.getMath()+" "+ vo.getName() + " " + vo.getPwd());
		model.addAttribute("name2",vo1);
		return "/sample/t";
	}
}
