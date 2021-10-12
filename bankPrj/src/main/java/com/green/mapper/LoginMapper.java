package com.green.mapper;

import java.util.List;

import com.green.vo.LoginVO;

public interface LoginMapper {
	public int register(LoginVO vo);
	public LoginVO loginWithPWAndName(LoginVO vo);//이름과 비밀번호를 가지고 VO 객체 얻기 
	//비밀번호 얻기위해 
	public LoginVO getLoginOneWithName(String login_name);
	//최근 데이터 하나를 가져오기 위해 
	public Long getMaxId();
	public List<LoginVO> getList();//회원 전체목록 
}
