package com.green.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.BuyMapper;
import com.green.vo.BuyVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BuyServiceImpl implements BuyService{
	
	@Setter(onMethod_=@Autowired)
	private BuyMapper mapper;

	@Override
	public void somebuy(BuyVO vo) {
		mapper.somebuy(vo);
		
	}

	@Override
	public List<BuyVO> buyList() {	
		return mapper.buyList();
	}

	@Override
	public int takeBack(String bnum) {
		return mapper.takeBack(bnum);
	}


	
}
