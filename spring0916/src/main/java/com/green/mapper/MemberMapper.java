package com.green.mapper;

import java.util.List;

import com.green.vo.MemberVO;

public interface MemberMapper {
	public List<MemberVO> findAll();
	public List<MemberVO> getList();
}
