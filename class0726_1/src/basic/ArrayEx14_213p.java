package basic;

public class ArrayEx14_213p {

	public static void main(String[] args) {
		for(String a : args) System.out.println(a);
	/*if(args.length != 3) {
			System.out.println("오류");
			System.exit(0);
		}*/
		String a = "7";
		String b = "+";
		String c = "10";
		
		System.out.println("a값 "+ Integer.parseInt(a));
		System.out.println("c값 "+ Integer.parseInt(c));
		System.out.println("b값 "+ b.charAt(0));
		
		String green = "7+6+4+3";
		
		
		int tt = Integer.parseInt(green.charAt(0));
		
		int num1 = Integer.parseInt(args[0]);
		char op = args[1].charAt(0);
		int num2 = Integer.parseInt(args[2]);
		int result = 0;
		switch(op) {
			case '+' :
				result = num1+num2;
				break;
			case '-' :
				result = num1-num2;
				break;
			case '*' :
				result = num1*num2;
				break;
			case '/' :
				result = num1/num2;
				break;
			default:
				System.out.println("지원되지 않는 연산입니다.");
		}
		System.out.println("결과 :" + result);
	}

}
