package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.BoardMapper;
import com.green.vo.BoardVO;
import com.green.vo.Criteria;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("2) 서비스 등록 :" +  board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("2) 서비스에서 데이터 하나 가져오기 ......." +bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("2) 서비스에서 수정 " + board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("2) 서비스에 데이터 삭제 :" +  bno);
		return mapper.delete(bno)==1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("2) 서비스에서 전체 목록 가져오기 ........." );
//		return mapper.getList();
//	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("2) 서비스에서 Criteria를 이용하여 전체 목록 가져오기 ........."  +cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("2) 서비스에서 전체 데이터 갯수 가져오기 ........."  +cri);
		return mapper.getTotalCount(cri);
	}

}
