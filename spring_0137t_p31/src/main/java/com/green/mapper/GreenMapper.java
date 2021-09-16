package com.green.mapper;

import java.util.List;

import com.green.vo.Green;

public interface GreenMapper {
	public String getName();
	public int getNumber();
	
	public List<Green> getList();
}
