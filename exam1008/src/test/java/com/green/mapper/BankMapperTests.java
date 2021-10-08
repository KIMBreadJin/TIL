package com.green.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.vo.BankVO;
import com.green.vo.LoanVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BankMapperTests {

	@Setter(onMethod_=@Autowired)
	BankMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	LoanMapper Lmapper;
	
	//@Test
	public void test() {
		mapper.getList();
	}
	//@Test
	public void test2() {
		BankVO vo = new BankVO();
		vo.setFree_name("홍길동");
		vo.setFree_password("2322");
		mapper.login(vo);
	}
	//@Test
	public void ifo() {
		LoanVO vo = new LoanVO();
		vo.setFree_id(4);
		vo.setFree_name("홍말자");
		vo.setLmoney(5400);
		vo.setLoan_total(6000);
		vo.setLoan_withdraw(600);
		Lmapper.insert(vo);
	}
	//@Test
	public void updateTest() {
		LoanVO vo = new LoanVO();
		vo.setLmoney(7000);
		vo.setLoan_withdraw(1000);
		vo.setFree_id(5);
		Lmapper.update(vo);
	}
	@Test
	public void depositTest() {
		BankVO vo = new BankVO();
		vo.setFmoney(800);
		vo.setFdeposit(300);
		vo.setFree_id(5);
		mapper.deposit(vo);
	}
		

}
