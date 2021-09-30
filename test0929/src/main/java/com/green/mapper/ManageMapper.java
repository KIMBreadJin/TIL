package com.green.mapper;

import java.util.List;

import com.green.vo.ManagePersonVO;

public interface ManageMapper {
	public List<ManagePersonVO> getList();
	public int getCount(String address);
	public List<ManagePersonVO> secondList();
}
