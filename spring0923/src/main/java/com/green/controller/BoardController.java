package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.service.BoardService;
import com.green.vo.BoardVO;
import com.green.vo.Criteria;
import com.green.vo.PageDTO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
	@Setter(onMethod_=@Autowired)
	BoardService service;

	@GetMapping("/register")
	public void register() {
		System.out.println("1) 컨트롤러 등록 get ");
	//	return "/board/register/";
	}
	@PostMapping("/register")
	public String postRegister(BoardVO vo, RedirectAttributes rttr) {
		System.out.println("1) 컨트롤러 등록 post "+ vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno()); //list.jsp에서 게시글의 번홀를 result
		return "redirect:list";
	}
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("1) 컨트롤러에서 목록 조회 " );
		model.addAttribute("pageMaker", new PageDTO(cri,123)); // 페이지 처리를 위한 추가
		model.addAttribute("list", service.getList(cri));
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long  bno, Model model) {
		log.info("1) 컨트롤러에서의 데이터 하나 조회 또는 수정" +bno);
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("1) 컨트롤러에서의 수정 :" +board);
		if(service.modify(board)) rttr.addFlashAttribute("result","success");
		return "redirect:/board/list";
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno , RedirectAttributes rttr) {
		log.info("1) 컨트롤러에서 의 삭제 :  " +  bno );
		if(service.remove(bno)) rttr.addFlashAttribute("result","success");
		return "redirect:/board/list";
	}

}
