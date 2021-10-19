package com.green.security;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.mapper.BoardMapper;
import com.green.mapper.ReplyMapper;
import com.green.vo.BoardVO;
import com.green.vo.Criteria;
import com.green.vo.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_=@Autowired)
	ReplyMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	BoardMapper bmapper;
	
	//@Test
	public void insetTest() {
		for(int i = 0; i < 20; i++) {
		ReplyVO vo = new ReplyVO();
		vo.setReply("댓글 처음 입력");
		vo.setReplyer("김영진 댓글");
		vo.setBno(538L);
		mapper.insert(vo);
		}
		
	}
	//@Test
	public void getListTest() {
		mapper.getListWithPaging(new Criteria(1,20), 1L);
	}
	//@Test
	public void updateTest() {
		ReplyVO vo =  new ReplyVO();
		vo.setRno(13L);
		vo.setReply("13번 댓글 수정");
		vo.setReplyer("13번 댓글 수정자 김영진");
		int cnt = mapper.update(vo);
		System.out.println("수정된 댓글의 개수 " + cnt);
	}
	//@Test
	public void testList2() {
		Criteria cri = new Criteria(1,10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 1L);
		replies.forEach(i->log.info(i));
	}
	//@Test
	public void testCnt() {
		mapper.getCountByBno(1L);
	}
	//@Test
	public void replyCnt() {
		for(long i = 0; i < 550; i++) {
			bmapper.updateReplyCnt(i,mapper.getCountByBno(i));
		}
	}
	
}
