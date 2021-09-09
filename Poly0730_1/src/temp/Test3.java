package temp;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

	public static void main(String[] args) {
		Map<Integer, Tv> map  = new HashMap<>();
		
		Tv tv1 = new Tv();
		tv1.setChannel(5);
		tv1.setPower(false);
		map.put(1, tv1);
		
		Tv tv2 = new Tv();
		tv2.setChannel(15);
		tv2.setPower(true);
		map.put(3, tv2);
		
		Tv tv3 = new Tv();
		tv3.setChannel(125);
		tv3.setPower(true);
		map.put(5, tv3);
		
	
		for( Integer key : map.keySet()) {
			System.out.println("키값은 " +key + "벨류: "+ map.get(key));
		}
		Map<String, Card> map2 = new HashMap<>();
		Card c1 = new Card();
		c1.setKind(3);
		c1.setNumber(12);
		
		Card c2 = new Card();
		c2.setKind(1);
		c2.setNumber(4);
		
		Card c3 = new Card();
		c3.setKind(4);
		c3.setNumber(5);
		map2.put("홍말자" , c3);
		map2.put("김개똥" , c2);
		map2.put("김영진" , c1);
		
		for(String key : map2.keySet()) {
			System.out.println("키값은 " +key + "벨류: "+ map2.get(key));
		
		}
			
			
		Map<Integer, Tire> map3 = new HashMap<>();
		Tire t1 = new Tire();
		t1.setColor("빨강");
		t1.setWeight(40);
		t1.setPosition("경기");
		
		Tire t2 = new Tire();
		t2.setColor("노랑");
		t2.setWeight(123);
		t2.setPosition("서울");
		
		Tire t3 = new Tire();
		t3.setColor("회색");
		t3.setWeight(52);
		t3.setPosition("제주도");
		
		map3.put(1 , t3);
		map3.put(2 , t2);
		map3.put(3 , t1);
			
		for(Integer key : map3.keySet()) {
				System.out.println("키값은 " +key + "벨류: "+ map3.get(key));
	}
}
}
