package com.green.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.service.BoardService;
import com.green.vo.BoardVO;
import com.green.vo.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {
	@Setter(onMethod_=@Autowired)
	BoardMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	BoardService service;
	

	//@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(20);
		List<BoardVO> list =mapper.getListWithPaging(cri);
		list.forEach(board-> log.info(board.getBno()));
	}
	//@Test
	public void testService() {
		service.getList(new Criteria(3,20));
	}
	
	//@Test
	public void insertTest() {
		for (int i = 0; i < 1500; i++) {
			BoardVO vo = new BoardVO();
			vo.setContent("내용"  + i + new Date());
			vo.setTitle("제목 " + i+   new Date());
			vo.setWriter("저자 " + i + new Date());
			mapper.insert(vo); //추가 	
		}
	}
	
	//문제 1 테스트 코드 작성하기 getTotalCount 
	//@Test
	public void a() {
		Criteria  a= new Criteria();
		mapper.getTotalCount(a);
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TCW");
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(i->log.info(i));
	}
	
	
}
