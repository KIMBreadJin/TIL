package com.green.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount; // 1페이지당 몇개를 표시할건지
	public Criteria() {
		this(1,10); // 1페이지, 페이지당 10개씩 기본 설정
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount; 
	}
}
