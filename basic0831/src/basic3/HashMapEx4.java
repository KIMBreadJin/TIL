package basic3;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx4 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("김자바",90);
		map.put("김자바",100);
		map.put("이자바",100);
		map.put("김자바",80);
		map.put("이자바",90);
		Set entrySetV = map.entrySet(); // 키들만 얻어와서 Set(집합)으로 반환함
		entrySetV.forEach(i->System.out.println(i));
		map.forEach(null);
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		Collection values = map.values();
		it = values.iterator();
		int total = 0;
		while(it.hasNext()) {
			Integer i = (Integer) it.next();
			total += i.intValue();
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float) total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
