package com.green.mapper;

import java.util.List;

import com.green.vo.FreeVO;

public interface FreeMapper {
	public List<FreeVO> getListWithName(String login_name);//해당 이름의 거래 내역
	public FreeVO getListOneWithName(String login_name);//최신 거래 하나만 가져옴 
	
	public int register(FreeVO vFreeVO);
	public List<FreeVO> getList();//예금주와 무관하게 다 가져오기 
}
