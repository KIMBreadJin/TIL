package com.green.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ManageMapperTests {

	@Setter(onMethod_=@Autowired)
	ManageMapper mapper;
	
	
	@Test
	public void getListTest() {
		mapper.getList();
	}
	@Test
	public void getCntTest() {
		mapper.getCount("서울");
	}
	@Test
	public void secondTest() {
		mapper.secondList();
	}
}