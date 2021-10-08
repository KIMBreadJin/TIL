package com.green.vo;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BankVO {
	private int free_id;
	private String free_name;
	private String free_password;
	private String free_serial;
	private float fdeposit;
	private float fwithdraw;
	private float fmoney;
	private boolean borrowable;
}
