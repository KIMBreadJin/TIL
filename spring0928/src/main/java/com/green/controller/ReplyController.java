package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.service.ReplyService;
import com.green.vo.Criteria;
import com.green.vo.ReplyPageDTO;
import com.green.vo.ReplyVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/replies/*")
@Slf4j
public class ReplyController {
	@Setter(onMethod_=@Autowired)
	ReplyService service;
	
	
	@PostMapping(value = "/new" , consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("1) 댓글 등록 컨틀롤러: ReplyVO: " + vo);
		int insertCount = service.register(vo);
		log.info("3) 댓글 등록된 갯수: insertCount: " + insertCount);
		return insertCount == 1?
				new ResponseEntity<>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		//produce(공급하다 그러므로 브라우저(client)에게 전달하는 타입, 순수한(PLAIN)문자열 타입)
		//대응되는 ResponseBody는 body만 전송 ResponseEntity는 body + header + status
		//consumer는 브라우저로 부터 수신(소비) 하는 데이터 형태(json)
		//브라우저로부터 request를 받으므로 requestBody 사용
	}
	
//	@GetMapping(value = "/pages/{bno}/{page}",
//			produces = {MediaType.APPLICATION_JSON_VALUE,
//					MediaType.APPLICATION_JSON_UTF8_VALUE})
//	public ResponseEntity<List<ReplyVO>> getList(
//			@PathVariable("page") int page,@PathVariable("bno") Long bno){
//		log.info("1) 컨트롤러에서의 전체 목록 불러오기 ........");
//		Criteria cri = new Criteria(page,10);
//		log.info(""+cri);
//		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
//	}
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page,@PathVariable("bno") Long bno){
		log.info("1) 컨트롤러에서의 전체 목록 불러오기 ........");
		Criteria cri = new Criteria(page,10);
		log.info(""+cri);
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{rno}",
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		log.info("1) 컨트롤러에서의 댓글 하나 가져오기 ........" + rno);
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{rno}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("1) 컨트롤러에서의 댓글 하나 삭제 ........" + rno);
		return service.remove(rno) ==1?
				new ResponseEntity<>("success", HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@RequestMapping(method = {RequestMethod.PUT,RequestMethod.PATCH},
			value = "/{rno}", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(
			@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		log.info("1) 컨트롤러에서의 댓글 하나 수정 : " + rno +"vo : " + vo);
		return service.modify(vo) ==1?
				new ResponseEntity<>("success", HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
