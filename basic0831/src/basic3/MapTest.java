package basic3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import basic.Green;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> a = new HashMap<>();
		a.put("홍길동","a");
		a.put("홍길동","b");
		a.put("홍길동","c");
		System.out.println(a.get("홍길동"));
		
		Map<String,Green> b= new HashMap<>();
		b.put("c", new Green());
		Green[] GrArr = new Green[10]; 
		for(int i = 0 ; i< 10; i++) {
			Green g = new Green();
			g.setEng(i+1);
			g.setMath(i+2);
			g.setKorea(i+3);
			g.setTotal(i+4);
			GrArr[i] = g;
		}
		for(int i = 0 ; i< 10; i++) {
			b.put("c"+(i+1), GrArr[i]);
		}
		System.out.println(b.get("c5").getMath());
		List<String> nameList = new LinkedList<String>();
	}
}
