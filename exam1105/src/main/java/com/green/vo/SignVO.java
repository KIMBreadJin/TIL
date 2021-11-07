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
public class SignVO {
	public Long sid;		//아이디
	public String sname;	//이름
	public String spassword;//비밀번호
	public String address;	//주소
	public String address2;	//상세주소
	public String phone;	//집전화
	public String phone2;	//핸드폰 전화
}