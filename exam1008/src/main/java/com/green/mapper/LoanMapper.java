package com.green.mapper;

import com.green.vo.LoanVO;

public interface LoanMapper {
	public LoanVO info(LoanVO vo);
	public void insert(LoanVO vo);
	public void update(LoanVO vo);
}
