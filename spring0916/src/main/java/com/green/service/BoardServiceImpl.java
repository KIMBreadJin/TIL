package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.BoardMapper;
import com.green.vo.BoardVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {

		
	}

	@Override
	public BoardVO get(Long bno) {

		return null;
	}

	@Override
	public boolean modify(BoardVO board) {

		return false;
	}

	@Override
	public boolean remove(Long bno) {

		return false;
	}

	@Override
	public List<BoardVO> getList() {

		return null;
	}

}
