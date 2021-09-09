package basic3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import basic.Green;

public class GreenTest {
	public static void main(String[] args) {
		Map<String, Green> map = new HashMap<>();	
		Green[] GrArr = new Green[15]; 
		
		boolean result;
		for(int i = 0 ; i< 15; i++) {
			Green g = new Green();	
			g.setEng((int)(Math.random()*100));
			g.setMath((int)(Math.random()*100));
			g.setKorea((int)(Math.random()*100));
			g.setTotal((int)(Math.random()*100*3));
			GrArr[i] = g;
		}
		for(int i = 0 ; i< 15; i++) {
			map.put("홍"+(i+1), GrArr[i]);
		}
	
		Set<String> set = map.keySet();
		System.out.println("키값 : " +set);
		for(String a:set) {
			int korea = map.get(a).getKorea();
			int math = map.get(a).getMath();
			int eng = map.get(a).getEng();
			int total = map.get(a).getTotal();
			result = map.get(a).greaterThan(korea, math,eng,total);
			System.out.println(korea + math + eng + total);
			System.out.println("결과는 = " + result);
		}	
	}

}
