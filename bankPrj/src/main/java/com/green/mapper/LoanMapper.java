package com.green.mapper;

import java.util.List;

import com.green.vo.LoanVO;

public interface LoanMapper {
	public int insert(LoanVO vo);
	public List<LoanVO> getList();
	public LoanVO getLoanWithName(String loan_name);
}
