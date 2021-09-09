package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareTest {
	public static void main(String[] args) {
		Person hong = new Person("3","홍길동",43,null);
		Person bang = new Person("5","김방자",143,null);
		Person getton = new Person("7","개똥",32,null);
		Person malza = new Person("6","말자",12,null);
		List<Person> people = new ArrayList<>();
		people.add(hong);
		people.add(bang);
		people.add(getton);
		people.add(malza);
		System.out.println(people);
		Collections.sort(people);
		System.out.println(people);
	}

}
