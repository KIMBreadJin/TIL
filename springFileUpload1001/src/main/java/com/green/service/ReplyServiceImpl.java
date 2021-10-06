package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.mapper.BoardMapper;
import com.green.mapper.ReplyMapper;
import com.green.vo.Criteria;
import com.green.vo.ReplyPageDTO;
import com.green.vo.ReplyVO;

import lombok.Setter;
@Service
public class ReplyServiceImpl  implements ReplyService{

	@Setter(onMethod_=@Autowired)
	ReplyMapper mapper;
	@Setter(onMethod_=@Autowired)
	BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		System.out.println("2) 서비스에서의 댓글 등록 " +vo);
		boardMapper.updateReplyCnt(vo.getBno(), 1); //추가  485p,댓글 갯수 
		return mapper.insert(vo);
	}
	@Override
	public ReplyVO get(Long rno) {
		System.out.println("2) 서비스에서의 댓글 하나 조회 :  " +rno);
		return mapper.read(rno);
	}
	@Override
	public int modify(ReplyVO vo) {
		System.out.println("2) 서비스에서의 댓글 수정  :  " +vo);
		return mapper.update(vo);
	}
	@Transactional
	@Override
	public int remove(Long rno) {
		System.out.println("2) 서비스에서의 댓글 삭제 댓글 번호  :  " +rno);
		ReplyVO vo = mapper.read(rno); //추가 485p, 게시글 번호를 구하기 위해 
		boardMapper.updateReplyCnt(vo.getBno(), -1); //추가  485p,댓글 갯수 
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		System.out.println("2) 서비스에서의 댓글 전체 목록 조회   :  cri: " +cri + "bno : " +bno);
		return mapper.getListWithPaging(cri, bno);
	}
	//추가 (434P)
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		System.out.println("2) 서비스에서의 페이지 이용한 댓글 전체 목록 조회   :  cri: " +cri + "bno : " +bno);
		return new ReplyPageDTO(mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}

}
