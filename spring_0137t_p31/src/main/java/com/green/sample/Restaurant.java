package com.green.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor // all arguments 생성자(constructor)
@NoArgsConstructor
@Setter
@Getter
public class Restaurant {
	
	//@Setter(onMetho_=@AutoWired)
	private Chef chef;
	private int math;


}
