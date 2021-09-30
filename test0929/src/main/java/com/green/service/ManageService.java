package com.green.service;

import java.util.List;

import com.green.vo.ManagePersonVO;

public interface ManageService {
	public List<ManagePersonVO> getList();
	public int getCount(String address);
	public List<ManagePersonVO> secondList();
}
