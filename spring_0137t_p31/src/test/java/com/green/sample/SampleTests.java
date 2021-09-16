package com.green.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@ToString
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	@Setter(onMethod_=@Autowired)
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		restaurant.setChef((new Chef()));
		restaurant.setMath(70);
		log.info(restaurant);
		log.info("----------------------");
		log.info(restaurant.getMath());
		log.info(restaurant.getChef());
	}
	@Test
	public void a () {
		Chef u = new Chef();
		u.setFood(5);
		u.setManager(67);
		u.setName("지점장");
		u.setWater(10);	
		restaurant.setChef(u);
		log.info(" " + restaurant.getChef());
	}
}
