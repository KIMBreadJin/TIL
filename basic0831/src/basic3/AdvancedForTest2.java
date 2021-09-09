package basic3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdvancedForTest2 {
	public static void main(String[] args) {	
	
	List<Integer> two = new ArrayList<>();
	int[] arr = new int[20];
	for(int i = 0 ; i<arr.length; i++) {
		arr[i] = (i+1);
		if(arr[i]%2==0) {
			two.add(arr[i]);
		}
	}
	two.forEach(j->System.out.println(j));
	
	Map<String, Integer> map = new HashMap<>();
	for(int i=0; i<arr.length; i++) {
		map.put("홍"+(i+1), arr[i]);
	}
	Set<String> set = map.keySet();
	System.out.println("키값 : " + set);
	
	int sum =0;
	for(String a : set) {
		
		if(map.get(a)%3==0) {	
			sum += map.get(a);	
		}	
	}
	System.out.println(sum);
	}
}

