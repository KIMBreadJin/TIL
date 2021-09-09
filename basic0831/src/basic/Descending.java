package basic;

import java.util.Comparator;

public class Descending implements Comparator<String> {
	
	@Override
		public int compare(String o1, String o2) {
			if(o1 instanceof Comparable && o2 instanceof Comparable) {
				Comparable c1 = (Comparable)o1;
				Comparable c2 = (Comparable)o2;
				return o1.compareTo(o2)*-1;
			}
			return -1;
	}

}
