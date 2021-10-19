package com.green.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.mapper.MemberMapper;
import com.green.security.domain.CustomUser;
import com.green.vo.MemberVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerUserDetailsService implements UserDetailsService{
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("userName으로 사용자(User)검색" + username);
		MemberVO vo = mapper.read(username);
		log.warn("memberMapper로 MemberVO를 가져오기 : " + vo);
		return vo == null? null : new CustomUser(vo);
	}

}
