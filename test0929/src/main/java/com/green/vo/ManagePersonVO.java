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
public class ManagePersonVO {
	private Long mpno;
	private String sname;
	private int spassword;
	private String paname;
	private String maname;
	private String sonname;
	private String address;
	private String phone;
	private int familynum;

}
