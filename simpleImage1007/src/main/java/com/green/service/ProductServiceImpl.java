package com.green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.ImageMapper;
import com.green.mapper.ProductMapper;
import com.green.vo.ImageVO;
import com.green.vo.ProductVO;

import lombok.Setter;

@Service
public class ProductServiceImpl implements ProductService {

	@Setter(onMethod_=@Autowired)
	ProductMapper pmapper;
	
	@Setter(onMethod_=@Autowired)
	ImageMapper imapper;
	
	
	@Override
	public int insertProduct(ProductVO vo) {	
		return pmapper.insert(vo);
	}

	@Override
	public int insertImage(ImageVO vo) {	
		return imapper.insert(vo);
	}

	@Override
	public Long getMaxPno() {
		return pmapper.getMaxPno();
	}

}
