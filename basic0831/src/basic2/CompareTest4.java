package basic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareTest4 {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("3","홍길동",43));
		people.add(new Person("5","김방자",14));
		people.add(new Person("7","개똥",32));
		people.add(new Person("6","말자",12));
		System.out.println("========아이디 정렬========");
		System.out.println(people);
		Collections.sort(people);
		Person.setComparator(Comparator.comparing(Person::getName));
		System.out.println(people);

	}

}
