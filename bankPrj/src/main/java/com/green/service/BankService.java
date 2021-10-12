package com.green.service;

import java.util.List;

import com.green.vo.FreeVO;
import com.green.vo.LoanVO;
import com.green.vo.LoginVO;

public interface BankService {
	public int register(LoginVO vo);
	public LoginVO loginWithPWAndName(LoginVO vo);//이름과 비밀번호를 가지고 VO 객체 얻기 
	
	public List<FreeVO> getListWithName(String login_name);//해당 이름의 거래 내역
	public FreeVO getListOneWithName(String login_name);//최신 거래 하나만 가져옴 
	
	public LoginVO getLoginOneWithName(String login_name);
	public int insertFree(FreeVO vo);
	
	public Long getMaxId();
	public List<LoginVO> getListLogin();//회원 전체목록 
	
	public List<FreeVO> getListFree();//대출과 구분하기 위해 Free추가 
	public List<LoanVO> getListLoan();//대출 
	
	public int insertLoan(LoanVO vo);
	public LoanVO getLoanWithName(String loan_name);
}
