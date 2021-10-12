package com.green.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoanVO {
	 private Long  loan_id;
	 private String    loan_name;
	 private String   loan_password;
	 private String    loan_serial;
	 private Float    loan_deposit;
	 private Float   loan_withdraw;
	 private Float   loan_balance;
}
