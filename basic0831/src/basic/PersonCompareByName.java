package basic;

import java.util.Comparator;

public class PersonCompareByName implements Comparator<Person>{

	@Override
	public int compare(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}

}
