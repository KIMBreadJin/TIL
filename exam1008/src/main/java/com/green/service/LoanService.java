package com.green.service;

import com.green.vo.LoanVO;

public interface LoanService {
	public LoanVO info(LoanVO vo);
	public void insert(LoanVO vo);
	public void update(LoanVO vo);
}
