package basic;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
	public static void main(String[] args) {
		String a = "";
		Test2 tes = new Test2();
		tes.setAddress("대구시");
		tes.setPapa("홍길동");
		tes.setMama("김말자");
		tes.setMarry(true);
		tes.setNumber(4);
		
		a = tes.point(tes.getAddress());
		
		System.out.println(tes.getAddnum());
		System.out.println(a);
	}
	Map<String, String> map = new HashMap<>();
	}
