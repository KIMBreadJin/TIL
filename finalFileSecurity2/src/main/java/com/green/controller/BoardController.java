package com.green.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.service.BoardService;
import com.green.vo.BoardAttachVO;
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
		//return "/board/register";
	}

	//문제 1) postmapping을 이용하여 register.jsp에 입력한 데이터를 BoardVO로 
	//받아서 service 를 통해 mapper를 통해 테이블에 추가되도록 하세요 
	//1-1) jsp 입력한 데이터가 constroller의 sysout으로 데이터가 넘어오는지 확인 
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String postRegister(BoardVO vo,RedirectAttributes rttr) {
		System.out.println("1) 컨트롤러 등록 post " +vo);
		if(vo.getAttachList()!=null) //vo내에 atttachList
			vo.getAttachList().forEach(i->log.info(""+i));
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());//list.jsp에서 게시글의번호를 result로 가지고함 
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public void list(Model model,Criteria cri) {
		log.info("1) 컨트롤러에서 목록 조회 " );
		model.addAttribute("pageMaker",new PageDTO(cri, 123)); //페이지 처리를 위한 추가
		int total = service.getTotal(cri);
		log.info("총 갯수 :" +  total);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));//추가 (p324) 
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long  bno, Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("1) 컨트롤러에서의 데이터 하나 조회 또는 수정 " +"bno:" + bno +" cri: " +cri);
		model.addAttribute("board", service.get(bno));
	}
	
	@PreAuthorize("principal.username==#writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr,@ModelAttribute("cri") Criteria cri) {
		log.info("1) 컨트롤러에서의 수정 : board : " +board + "cri : " +cri);
		if(service.modify(board)) rttr.addFlashAttribute("result","success");
		
		rttr.addAttribute("pageNum", cri.getPageNum());//추가
		rttr.addAttribute("amount",cri.getAmount());//추가 
		rttr.addAttribute("type",cri.getType());//추가 
		rttr.addAttribute("keyword",cri.getKeyword());//추가 
		return "redirect:/board/list";
	}
	
	@PreAuthorize("principal.username==#writer")
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno , @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		log.info("1) 컨트롤러에서 의 삭제 :  " +  bno );
		//p581
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		
		if(service.remove(bno)) {
			//첨부파일 삭제
			deleteFile(attachList);
			rttr.addFlashAttribute("result","success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());//추가
//		rttr.addAttribute("amount",cri.getAmount());//추가 
//		rttr.addAttribute("type",cri.getType());//추가 
//		rttr.addAttribute("keyword",cri.getKeyword());//추가 
		return "redirect:/board/list" +cri.getListLink();//위의 rttr을 Criteria 클래스에서 생성한 함수이용하여 전달함 
	}
	
	@GetMapping(value = "/getAttachList" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		log.info("1)컨트롤러에서 첨부파일 전체목록 가져오기 : " + bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	//P581
	private void deleteFile(List<BoardAttachVO> attachList){
		if(attachList == null || attachList.size()==0) return;
		log.info(" 컨트롤러에서 첨부 파일  삭제 " + attachList);
		attachList.forEach(attach->{
			try {
				Path file = Paths.get("c:\\upload\\"+ 
							attach.getUploadPath()+"\\" + attach.getUuid()+"_" + attach.getFileName().trim());
				Files.deleteIfExists(file);//thumbnail 파일 삭제
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("c:\\upload\\" + 
							attach.getUploadPath()+"\\s_"+attach.getUuid()+"_" + attach.getFileName().trim());
					Files.delete(thumbNail);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
