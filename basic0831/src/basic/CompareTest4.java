package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareTest4 {
	public static void main(String[] args) {
		People.add(new Person("3","홍길동",43,Comparator.comparing(Person::getName)));
		Person bang = new Person("5","김방자",143,null);
		Person getton = new Person("7","개똥",32,null);
		Person malza = new Person("6","말자",12,null);
		List<Person> people = new ArrayList<>();
		
		System.out.println(people);

	}

}
