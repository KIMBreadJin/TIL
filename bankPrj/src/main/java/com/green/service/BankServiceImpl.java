package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.FreeMapper;
import com.green.mapper.LoanMapper;
import com.green.mapper.LoginMapper;
import com.green.vo.FreeVO;
import com.green.vo.LoanVO;
import com.green.vo.LoginVO;

import lombok.Setter;

@Service
public class BankServiceImpl implements BankService {

	@Setter(onMethod_=@Autowired)
	private LoginMapper loginMapper;
	
	@Setter(onMethod_=@Autowired)
	private FreeMapper freeMapper;
	
	@Setter(onMethod_=@Autowired)
	private LoanMapper loanMapper;	
	
	
	@Override
	public int register(LoginVO vo) {
		System.out.println("서비스에서 로그인 등록 ");
		return loginMapper.register(vo);
	}

	@Override
	public LoginVO loginWithPWAndName(LoginVO vo) {
		System.out.println("서비스에서 이름과 비밀번호로 객체 얻기 " + vo);
		return loginMapper.loginWithPWAndName(vo);
	}

	@Override
	public List<FreeVO> getListWithName(String login_name) {
		System.out.println("서비스에서 로그인 된 사람의 전체 목록  :  " + login_name);
		return freeMapper.getListWithName(login_name);
	}

	@Override
	public FreeVO getListOneWithName(String login_name) {
		System.out.println("서비스에서 로그인 된 사람의 최신 데이터 하나   :  " + login_name);
		return freeMapper.getListOneWithName(login_name);
	}

	@Override
	public LoginVO getLoginOneWithName(String login_name) {
		System.out.println("서비스에서 로그인 된 사람의 LoginVO   :  " + login_name);
		return loginMapper.getLoginOneWithName(login_name);
	}

	@Override
	public int insertFree(FreeVO vo) {
		System.out.println("서비스에서  자유 로운 예금 등록   :  " + vo);
		return freeMapper.register(vo);
	}

	@Override
	public Long getMaxId() {
		System.out.println("서비스에서  로그인 최대 id값    :  ");
		return loginMapper.getMaxId();
	}

	@Override
	public List<LoginVO> getListLogin() {
		System.out.println("서비스에서  회원 목록 조회    :  ");
		return loginMapper.getList();
	}

	@Override
	public List<FreeVO> getListFree() {
		System.out.println("서비스에서  전체 자유 입출금 내역조회     :  ");
		return freeMapper.getList();
	}

	@Override
	public List<LoanVO> getListLoan() {
		System.out.println("서비스에서  대출 입출금 내역조회     :  ");
		return loanMapper.getList();
	}

	@Override
	public int insertLoan(LoanVO vo) {
		System.out.println("서비스에서  대출 등록     :  ");
		return loanMapper.insert(vo);
	}

	@Override
	public LoanVO getLoanWithName(String loan_name) {
		System.out.println("서비스에서 이름으로 대출 거래 최신 데이터 조회      :  ");
		return loanMapper.getLoanWithName(loan_name);
	}

}
