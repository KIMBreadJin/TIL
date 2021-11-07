package com.green.service;

import java.util.List;

import com.green.vo.SignVO;

public interface SignService {
	public void signup(SignVO sign); // 회원가입
	public SignVO login(SignVO vo); // 로그인
}
