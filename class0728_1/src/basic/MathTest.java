package basic;

import java.util.Scanner;

public class MathTest {

	public static void main(String[] args) {
		int first = 0 ,second=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("워놔는 연산을 선택하세요 1)더하기 2)빼기 3)곱하기 4)나누기");
		int op =sc.nextInt();
		System.out.println("첫번째 숫자를 입력하세요");
		second = sc.nextInt();
		long result1 = 0;
		switch(op) {
			case 1:
				result1 = mm.add(5L,3L);
				System.out.println(result1);
				break;
			case 2:
				result = mm.substeact(5L,3L);
				System.out.println(result1);
				break;
			case 3:
				result1 = mm.multiply(5L,3L);
				System.out.println(result1);
				break;
			case 4:
				double result4 = mm.divide(5L,3L);
				System.out.println(result1);
				break;
				default:
					System.out.println("잘못 입력하셨습니다");
					break;
		
		}
	}

}
