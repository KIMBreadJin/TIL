package com.green.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2 ) throws Exception {
		int result = 0;
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				result += Integer.parseInt(str1) + Integer.parseInt(str2);
			}
			result=0;
		}
		return result;
	}

}
