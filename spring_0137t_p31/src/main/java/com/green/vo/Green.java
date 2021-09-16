package com.green.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Green {
	private int num;
	private String name;
	private String pwd;
	private int math;
	private int kor;
	private int eng;
}
