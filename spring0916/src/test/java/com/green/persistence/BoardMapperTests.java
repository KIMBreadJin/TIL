package com.green.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.mapper.BoardMapper;
import com.green.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	BoardMapper board;
	
	
	//@Test
	public void c() {
		
		String str = "";
		board.getList().forEach(i->System.out.println(i));
		for(BoardVO i : board.getList()) {
			str+=i.getTitle()+i.getContent();
		}
		System.out.println(str);
		List<BoardVO> list = board.getList();
		for(int i=0; i<10; i++) {
			str += list.get(i).getTitle() + list.get(i).getContent();
		}
		System.out.println( "결과는 " + str);
	}
	//@Test
	public void insertTest() {
		BoardVO a = new BoardVO();
		String[] str = {"월", "화", "수", "목","금","토","일"};
		a.setContent("오늘은 목요일 입니다");
		a.setTitle("제목이에요 그린");
		a.setWriter("홍길동1");
		board.insert(a);
		
		for(int i=0; i<str.length; i++) {
			a= new BoardVO();
			a.setContent("오늘은 " + str[i]+"요일 입니다.");
			a.setTitle("제목입니다. 그린" + (i+1));
			a.setWriter("홍길동" +(i+3));
			board.insert(a);
		}
	}
	//@Test
	public void testInsertSelectKey() {
		BoardVO a = new BoardVO();
		a.setContent("오늘은 목요일 입니다");
		a.setTitle("제목이에요 그린");
		a.setWriter("홍길동1");
		board.insertSelectKey(a);
		log.info(a);
	}
	//@Test
	public void read() {
		//존재하는 bno로 입력하세요
		BoardVO bod = board.read(5L);
	}
	//@Test
	public void delete() {
		log.info("삭제된 데이터 갯수 " + board.delete(3L));
	}
	@Test
	public void update() {
		BoardVO bod = new BoardVO();
		bod.setBno(5L);
		bod.setTitle("수정된제목");
		bod.setContent("수정된내용");
		bod.setWriter("김영진");
		int cnt = board.update(bod);
		log.info("수정된 갯수 : " + cnt);
	}
}
