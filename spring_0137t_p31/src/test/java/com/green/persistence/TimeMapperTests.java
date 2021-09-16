package com.green.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.mapper.GreenMapper;
import com.green.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	@Setter(onMethod_=@Autowired)
	private TimeMapper timeMapper;
	
	@Setter(onMethod_=@Autowired)
	private GreenMapper mapper;
	
	@Test
	public void aaaaaa() {
		log.info(mapper.getName());
		log.info(mapper.getNumber());
	}
	
	//@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	//@Test
	public void aaa() {
		log.info(timeMapper.a());
		log.info(timeMapper.stime());
		log.info(timeMapper.timeplus());
	}
	
	//@Test
	public void getTime2Test(){
		log.info(timeMapper.getTime2());
	}

}
