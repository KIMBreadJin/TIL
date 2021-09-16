package com.green.mapper;

import java.util.List;

import com.green.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	public void insert(BoardVO board); // 데이터 추가
	public void insertSelectKey(BoardVO board);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO board);
}
