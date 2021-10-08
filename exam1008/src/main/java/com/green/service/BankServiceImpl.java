package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.BankMapper;
import com.green.vo.BankVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BankServiceImpl implements BankService{
	
	@Setter(onMethod_=@Autowired)
	private BankMapper mapper;

	@Override
	public List<BankVO> getList() {
		log.info("1) 전체 목록 가져오기");
		return mapper.getList();
	}

	@Override
	public BankVO login(BankVO vo) {
		return mapper.login(vo);
	}

	@Override
	public void deposit(BankVO vo) {
		vo.setFmoney(vo.getFmoney() + vo.getFdeposit());
		mapper.deposit(vo);
		
	}

	@Override
	public void withdraw(BankVO vo) {
		vo.setFmoney(vo.getFmoney() - vo.getFwithdraw());
		mapper.withdraw(vo);
		
	}

		


}
