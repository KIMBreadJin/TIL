package basic;

public class ArrayEx14_213p2 {

	public static void main(String[] args) {
		
		String green = "7+6+4+3";
		String a1 = String.valueOf(green.charAt(0));
		System.out.println("첫번째 문자 : "+ a1);
		int aNum1 = Integer.parseInt(a1);
		System.out.println("문자열을 정수로 변환 " + aNum1);
		
		String a2 = String.valueOf(green.charAt(1));
		System.out.println("두번째 문자 : "+ a2);
		
		
		String a3 = String.valueOf(green.charAt(2));
		System.out.println("세번째 문자 : "+ a3);
		int aNum2 = Integer.parseInt(a3);
		System.out.println("문자열을 정수로 변환 " + aNum2);
		
		int total = 0;
		for (int i = 0; i<green.length(); i+=2) {
			total += Integer.parseInt(String.valueOf(green.charAt(i)));
		}
		System.out.println("총합은 " + total);
		}
}