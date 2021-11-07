package com.green.mapper;


import com.green.vo.SignVO;

public interface SignMapper {
	public void signup(SignVO sign); // 회원가입
	public SignVO login(SignVO vo); //로그인 하기
}
