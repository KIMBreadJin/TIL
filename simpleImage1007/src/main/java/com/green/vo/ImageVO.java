package com.green.vo;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ImageVO {
	private Long ino;
	private String uploadPath;
	private String uuid;
	private String fileName;
	private Long refPno;
}
