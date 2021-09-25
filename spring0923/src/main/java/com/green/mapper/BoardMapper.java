package com.green.mapper;

import java.util.List;

import com.green.vo.BoardVO;
import com.green.vo.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList(); //3번 동작 , mybatis를 통해 db에 접근해서 데이터를 가져온다 
	public List<BoardVO> getListWithPaging(Criteria cri);
	public void insert(BoardVO board); //데이터 추가 
	public void insertSelectKey(BoardVO board);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO board);
}
