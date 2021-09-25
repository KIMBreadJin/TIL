package com.green.service;

import java.util.List;

import com.green.vo.BoardVO;
import com.green.vo.Criteria;

public interface BoardService {
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	//public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
}
