package com.green.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BuyVO {
	public Long sid;		//아이디
	public String bname;	//이룸
	public String bpassword;//비밀번호
	public String baddress;	//주소
	public String baddress2;//상세주소
	public String bphone2;	//핸드폰번호
	public String bnum;		//송장번호
	public String product;	//구매할 제품
	public Float price;		//제품의 가격
	public Long amount;		//제품의 양
	public Float  total;	//총 금액
	public Float  coupon;	//쿠폰 액수
	public String cuse;		//쿠폰 사용여부
}
