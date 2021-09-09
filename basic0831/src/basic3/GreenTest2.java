package basic3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import basic.Green;

public class GreenTest2 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		for(int i : arr) System.out.println(i);
		
		String[] arrStr = {"홍길동", "홍말자", "김개똥","홍개똥","그린","블루"};
		for(String i:arrStr) System.out.println(i);
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i<50; i++) {
			list.add(i+1);
		}
		for(int i : list) System.out.println(i+" ");
		
		Map<String, Integer> map = new HashMap<>();
		for(int i =0 ; i<10; i++) {
			map.put("홍길동"+i,(i+1)*20);
		}
		for(String i : map.keySet()) System.out.println(map.get(i)+" ");
		
		List<String> list2 = new ArrayList<>();
		for(int i = 0; i<30; i++) {
			list2.add("홍말자" +(i+1)*2 );
		}
		System.out.println("\n 여기는 문자열 list ");
		for(String i:list2) System.out.println(i+ " ");
		//문제 6) key에 green 객체 10개 추가, 멤버변수에 데이터 저장된 상태로 추가
		//문제7) keySet() 호출하면 map의 key값들을 가져올수 있으므로 그 key값을 이용하여 
		//저장된 value(green객체) 10개를 얻을 수 있다.
		
		
		//문제8) greaterThan 호출하여 결과 출력
		
	}

}
