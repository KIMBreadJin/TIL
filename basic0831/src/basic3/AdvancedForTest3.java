package basic3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import basic.Green;

public class AdvancedForTest3 {
	public static void main(String[] args) {
		List<Green> list = new ArrayList<>();
		
		
		boolean result = false;
		for(int i = 0 ; i < 20; i++) {
			Green g= new Green();
			g.setEng((int)(Math.random()*100));
			g.setMath((int)(Math.random()*100));
			g.setKorea((int)(Math.random()*100));
			g.setTotal((int)(Math.random()*100*3));
			list.add(g);
		}	
		for(Green i : list) {
			System.out.println("국어 : " + i.getKorea());
			System.out.println("수학 : " + i.getMath());
			System.out.println("영어 : " + i.getEng());
			System.out.println("토탈 : " + i.getTotal());
			result = i.greaterThan(i.getEng(),i.getKorea(),i.getMath(), i.getTotal());
			System.out.println(result);
		}
		
	}
	

}

