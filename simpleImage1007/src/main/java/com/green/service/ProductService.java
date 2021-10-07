package com.green.service;

import com.green.vo.ImageVO;
import com.green.vo.ProductVO;

public interface ProductService {
	public int insertProduct(ProductVO vo);
	public int insertImage(ImageVO imageVO);
	public Long getMaxPno(); // 제품 번호가 가장 큰 수는 몇인가
}
