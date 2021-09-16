package com.green.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor // 멤버변수의 모든 값을 저장할 수 있는 파라미터(all arguments(인자.매개변수)) 생성
@Setter
@Getter
@ToString
public class SampleDTOList {
	private List<SampleDTO> list;
	
	public SampleDTOList() { // NoArgsContrutor 와 같은것 = 기본 생성자 (파라미터 없는 생성자
		list = new ArrayList<>();
	}
}
