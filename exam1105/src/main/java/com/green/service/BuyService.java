package com.green.service;


import java.util.List;

import com.green.vo.BuyVO;

public interface BuyService {
	public void somebuy(BuyVO vo); //구매하기
	public List<BuyVO> buyList(); //구매목록보기
	public int takeBack(String bnum); //반품하기
}
