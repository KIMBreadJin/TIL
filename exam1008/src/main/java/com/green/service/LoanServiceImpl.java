package com.green.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.LoanMapper;
import com.green.vo.BankVO;
import com.green.vo.LoanVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoanServiceImpl implements LoanService{
	
	@Setter(onMethod_=@Autowired)
	private LoanMapper mapper;

	@Override
	public LoanVO info(LoanVO vo) {
		return mapper.info(vo);
	}

	@Override
	public void insert(LoanVO vo) {
		mapper.insert(vo);
	}

	@Override
	public void update(LoanVO vo) {
		vo.setLmoney(vo.getLmoney() - vo.getLoan_withdraw());
		mapper.update(vo);
		
	}


}
