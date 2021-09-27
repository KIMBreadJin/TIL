package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.ReplyMapper;
import com.green.vo.BoardVO;
import com.green.vo.Criteria;
import com.green.vo.ReplyVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		System.out.println("2) 서비스에서의 댓글 등록 :" +  vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		System.out.println("2) 서비스에서 댓글 하나 조회 ......." +rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		System.out.println("2) 서비스에서 댓글 수정 " + vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		System.out.println("2) 서비스에 데이터 삭제 댓글 번호 :" +  rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		System.out.println("2) 서비스에서 댓글전체"  +cri + "bno : " + bno);
		return mapper.getListWithPaging(cri,bno);
	}


}
