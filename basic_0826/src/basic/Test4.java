package basic;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
	public static void main(String[] args) {
	List<Integer> a = new ArrayList<Integer>();

	List<List<Integer>> al = new ArrayList<>();
	List<List<List<Integer>>> al3D = new ArrayList<>();
	for (int k = 0; k < 6; k++) {
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 5; i++) {
			a.add((i+3)*7+1 + (j+2)*3);
			}
			al.add(a);
			a = new ArrayList<Integer>(); //초기화
		}
		al3D.add(al);
		al=new ArrayList<>();
	}
		al3D.forEach(i->{
			i.forEach(j->j.forEach(
					k-> System.out.println(k)));
		});
	}
}
