package basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iterator {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i< 5; i++) {
			list.add(""+(i+1));
			}
			
		
		Iterator<String> it = list.iterator(); // 반복자 생성하여 next  메서드 호출하여 다음요소에 접근
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next()); // 여기서 예외 발생
		while(it.hasNext()) // 다음 요소가 있느냐 있으면 true 없으면 false or null
			System.out.println(it.next());
		}

}
