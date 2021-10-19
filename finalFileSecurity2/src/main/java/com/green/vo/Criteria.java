package com.green.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;// 1페이지장 몇개를 표시할지
	
	private String type;// 추가 검색을 위한 , 타입은  title(T), content(C),writer(W), WC 
	private String keyword;//검색어 추가 
	public Criteria() {
		this(1,10);// 1페이지 ,페이지당 10개씩 기본 설정 
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	public String[] getTypeArr() { //mybatis에서  typeArr을 사용 
		return type==null? new String[] {} : type.split("");//문자열을 공백으로 분리 
	}
	//"WC" => ["W","C"] ,"TWC" => ["T","W","C"]
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type",this.getType())
				.queryParam("keyword", this.getKeyword());
		String result = builder.toUriString();
		System.out.println("UriCompoentBuilder : " +result);
		return result;
	}
}
