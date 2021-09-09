package basic;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, Integer> al = new HashMap<>();
		al.put("홍길동", 5);
		al.put("그린", 3);
		al.put("그린2", 7);
		al.put("그린3", 9);
		al.put("그린5", 13);

		System.out.println(al.get("홍길동"));
		System.out.println(al.get("그린"));
		System.out.println(al.get("그린2"));
		System.out.println(al.get("그린3"));
		System.out.println(al.get("그린5"));
	}

}
