package com.green.mapper;

import com.green.vo.ProductVO;

public interface ProductMapper {
	public int insert(ProductVO vProductVO);
	public Long getMaxPno(); // 제품 번호가 가장 큰 수는 몇인가
}
