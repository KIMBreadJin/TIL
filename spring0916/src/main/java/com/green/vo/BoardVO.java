package com.green.vo;

import java.util.Date;

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
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String Writer;
	private Date regDate;
	private Date updateDate;
	

}
