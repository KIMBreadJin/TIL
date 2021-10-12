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
public class FreeVO {
	private Long free_id ;
    private String free_name;
    private String free_password;
    private String free_serial;
    private Float free_deposit;
    private Float  free_withdraw;
    private Float  free_balance;
    private String free_loan;
}
