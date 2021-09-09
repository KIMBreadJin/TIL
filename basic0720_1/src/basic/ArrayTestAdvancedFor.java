package basic;

import java.util.ArrayList;
import java.util.List;

public class ArrayTestAdvancedFor {

	public static void main(String[] args) {
		
		String[] str = {"홍길동", "홍말자", "김개똥", "홍개똥"};
		
		for(String a : str) System.out.println(a);
		for(int i=0; i<str.length; i++) System.out.println(str[i]);
		
		List<Integer> al = new  ArrayList<Integer>();
		for (int i = 0; i<100; i++){
			al.add((int)(Math.random()*100));
		}
		for(int a: al) System.out.println(a);
		}
	}