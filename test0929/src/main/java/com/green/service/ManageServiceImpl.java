package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.ManageMapper;
import com.green.vo.ManagePersonVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManageServiceImpl implements ManageService{

	@Setter(onMethod_=@Autowired)
	private ManageMapper mapper;
	
	@Override
	public List<ManagePersonVO> getList() {
		log.info("1) 전체 목록 가져오기");
		return mapper.getList();
	}

	@Override
	public int getCount(String address) {
		log.info("1) 지역별 인원수 가져오기" + address);
		return mapper.getCount(address);
	}

	@Override
	public List<ManagePersonVO> secondList() {
		log.info("1) 지역별 인원수 많은순");
		return mapper.secondList();
	}

}
