package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
	public static void main(String[] args) {
		List<Integer> in = new ArrayList<Integer>(); //Integer (클래스) <-> int(기본 자료형)
		
		for(int i=0; i<100; i++) in.add((i+1)*10);
		for(int i : in) System.out.println(i);
		
		List<Float> f = new ArrayList<Float>();
		for(int i=0; i<100; i++) f.add((float)(i+1)*10);
		
		for(float i : f) System.out.println(i);

		//key, value로 이루어진 Map
		//데이터 저장은 put
		//데이터 읽기는 get으로 키값을 주면 value를 얻을 수 있다.
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "홍길동");
		map.put(2, "홍길이");
		map.put(3, "홍이링");
		map.put(4, "홍d말자");
		map.put(50, "홍나이");
		map.put(13, "홍우라");
		map.put(154, "홍바니");
		map.put(415, "홍구니");
		String tt = map.get(1);
		System.out.println(tt);
		
		tt= map.get(13);
		System.out.println(tt);
}
}
