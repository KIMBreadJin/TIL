package basic;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
	List<Integer> a = new ArrayList<Integer>();
	List<Integer> b = new ArrayList<Integer>();
	List<Integer> c = new ArrayList<Integer>();
	
	List<List<Integer>> al = new ArrayList<>();
	a.add(5);
	a.add(7);
	a.add(11);
	
	b.add(23);
	b.add(123);
	b.add(1213);
	b.add(17);
	
	c.add(1123);
	c.add(6);
	c.add(43);
	c.add(111);
	c.add(121);
	c.add(111);
	al.add(a);
	al.add(b);
	al.add(c);
	al.forEach(i->{
		i.forEach(j-> System.out.println(j));
	});
	}
}
