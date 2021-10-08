package com.green.mapper;

import java.util.List;

import com.green.vo.BankVO;

public interface BankMapper {
	public List<BankVO> getList();
	public BankVO login(BankVO vo);
	public void deposit(BankVO vo);
	public void withdraw(BankVO vo);
}
