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
public class LoanVO {
	private int free_id;
	private String free_name;
	private float loan_total;
	private float loan_withdraw;
	private float lmoney;
}
