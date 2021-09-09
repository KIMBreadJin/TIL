package basic;

import java.util.Comparator;

public class PersonCompareByNameDesc implements Comparator<Person>{

	@Override
	public int compare(Person a, Person b) {
		return b.getName().compareTo(a.getName());
	}

}
