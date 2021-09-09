package basic;

public class Test01 {
	public static void main(String[] args) {
		String red = "2222*";

		int result = 0;
		char op = red.charAt(red.length()-1);
		for (int i = 0; i<red.length()-1; i++) {
			switch(op) {
			case '+' :
				result += Integer.parseInt(String.valueOf(red.charAt(i)));
				break;
			case '*' :
				result *= Integer.parseInt(String.valueOf(red.charAt(i)));
				break;
			default:
				System.out.println("지원되지 않는 연산입니다.");
		}
		
		}System.out.println("결과는 "+ op + " " + result);
}
}

