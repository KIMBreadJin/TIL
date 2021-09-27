package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.ReplyMapper;
import com.green.vo.Criteria;
import com.green.vo.ReplyVO;

import lombok.Setter;
@Service
public class ReplyServiceImpl  implements ReplyService{

	@Setter(onMethod_=@Autowired)
	ReplyMapper mapper;
	
	
	@Override
	public int register(ReplyVO vo) {
		System.out.println("2) 서비스에서의 댓글 등록 " +vo);
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
	@Override
	public int remove(Long rno) {
		System.out.println("2) 서비스에서의 댓글 삭제 댓글 번호  :  " +rno);
		return mapper.delete(rno);
	}
	@Override
	public int rnocnt(Long bno) {
		System.out.println("2) 서비스에서의 댓글 삭제 댓글 번호  :  " +bno);
		return mapper.rnocnt(bno);
	}
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		System.out.println("2) 서비스에서 댓글전체"  +cri + "bno : " + bno);
		return mapper.getListWithPaging(cri,bno);
	}
//	@Override
//	public List<ReplyVO> getList(Criteria cri, Long bno) {
//		System.out.println("2) 서비스에서의 댓글 전체 목록 조회   :  cri: " +cri + "bno : " +bno);
//		return mapper.getListWithPaging(cri, bno);
//	}

}
