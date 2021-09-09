package basic;

import java.util.Arrays;

public class CompartorEx {

	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog","Lion","Tiger"};
		Arrays.sort(strArr); //String의 comparable구현에 의한 정렬
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		Arrays.sort(strArr,new Descending());//역순 정렬
		System.out.println("strArr = " + Arrays.toString(strArr));
		}
}
