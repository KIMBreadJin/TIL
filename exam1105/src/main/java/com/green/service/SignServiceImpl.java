package com.green.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.SignMapper;
import com.green.vo.SignVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignServiceImpl implements SignService{
	
	@Setter(onMethod_=@Autowired)
	private SignMapper mapper;

	@Override
	public void signup(SignVO sign) {
		log.info("1)회원가입 완료");
		mapper.signup(sign);
	}

	@Override
	public SignVO login(SignVO vo) {
		return mapper.login(vo);
	}


	
}
