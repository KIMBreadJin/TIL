package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.mapper.BoardMapper;
import com.green.vo.BoardVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	@Setter(onMethod_=@Autowired)
	BoardMapper mapper;
	

	@RequestMapping("/a")
	public String basic() {
		log.info("여기는 컨트롤러 basic1..................");
		return "/sample/g";
	}
	
	//@RequestMapping("/b")
//	public String basic1(Green vo, Model model) {
//		List<Green> vo1 = gmapper.getList();
//		//log.info(" " + vo.getEng() + " " + vo.getKor() +" " +vo.getMath()+" "+ vo.getName() + " " + vo.getPwd());
//		model.addAttribute("name2",vo1);
//		return "/sample/t";
//	}
	
//	@RequestMapping("/c")
//	public String basic2(Model model) {
//		List<MemberVO> mv1 = mapper.findAll();
//		model.addAttribute("test", mv1);
//		return "/sample/m";
//	}
//	@RequestMapping("/ex01")
//	public String ex01(SampleDTO dto) {
//		log.info(" " + dto);
//		return "ex01";
//	}
//	@RequestMapping("/m")
//	public String ans(SampleDTO dto) {
//		log.info(" " + dto);
//		return "ans";
//	}
//	@RequestMapping("/ex02")
//	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) { //RequestParam 안써도 되긴하지만 매칭도와줄때 씀
//		log.info("이름: " + name);
//		log.info("나이: " + age);
//		return "ex02";
//	}
//	@GetMapping("/ex02List")
//	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
//		log.info("ids: " + ids); //ex02List?ids=1111&ids=22&ids=345
//		return "ex02List";
//	}
//	@GetMapping("/ex02Bean")
//	public String ex02Bean(SampleDTOList list, Model model) {
//		log.info("list dto : " + list.getList());
//		model.addAttribute("b", list.getList());
//		return "ex02Bean";
//		//sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=ccc&list%5B0%5D.age=12&list%5B1%5D.age=13
//		// [ = %5B ]   %5D
//	}
//	@GetMapping("/ex04")
//	public String ex04(SampleDTO dto, int page, Model model) {
//		log.info("dto : " +dto);
//		log.info("page:" + page);
//		model.addAttribute("dto", dto); // forEach
//		model.addAttribute("page", page);
//		return "/sample/ex04"; // sample/ex04?name=aaa&age=11&page=9
//	}
//	
//	@GetMapping("/ex05")
//	public String ex05() {
//		return "/sample/ex05";  // 이것으로 접근하여 ex04로 form태그를 이용하여 출력하도록 하십쇼
//	}
//	@GetMapping("/ex06")
//	public @ResponseBody SampleDTO ex06() { //request => reponse, header 까지 같이 정보전달(ResponseEntity
//		log.info("/ex06,,,,,");
//		SampleDTO dto = new SampleDTO();
//		dto.setAge(10);
//		dto.setName("홍길동");
//		return dto;
//	}
//	@GetMapping("/ex07")
//	public ResponseEntity<String> ex07(){
//		log.info("/ex07...........");
//		String msg= "{\"name\" : \"홍길동\"}";
//		HttpHeaders header = new HttpHeaders();
//		header.add("Content-type","application/json;charset=UTF-8");
//		return new ResponseEntity<>(msg,header,HttpStatus.OK);
//	}
	@GetMapping("/in")
	public String insertBoard() {
		return "/sample/in";
	}
	@GetMapping("/input")
	public String inputBoard(BoardVO vo, String rand,Model model) {
		int num = (Integer.parseInt(rand));
		System.out.println(num);
		String[] title = {"제","목","입","니","다"};
		String[] content = {"내","용","그","린","오"};
		String[] writer = {"홍길동","홍말자","김개똥","그린","블루"};
		for(int j=0; j<num; j++) {
			for(int i =0; i<5; i++ ) {
				vo.setTitle(title[(int)(Math.random()*5)]);
				vo.setContent(content[(int)(Math.random()*5)]);
				vo.setWriter(writer[(int)(Math.random()*5)]);
			}	
			mapper.insert(vo);
		}
	
		model.addAttribute("ist", vo);
		return null;	
	}
	
}
