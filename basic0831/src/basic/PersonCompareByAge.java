package basic;

import java.util.Comparator;

public class PersonCompareByAge implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getAge() -o2.getAge();
	}

}
