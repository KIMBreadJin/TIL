package basic;

import java.util.Scanner;

public class FastFinal {

	public static int sum(int a, int b) {
		return a+b;
	}
	public static int minus(int a, int b) {
		return a-b;
	}
	public static int mul(int a, int b) {
		return a*b;
	}
	public static int div(int a, int b) {
		return a/b;
	}
	public static void main(String[] args) {
		int result=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 계산을 입력하세요 1)더하기 2)뺴기 3)곱하기 4)나누기");
		int input = sc.nextInt();
		switch(input) {
		case 1:
			result = sum(4,5);
			System.out.println(result);
			break;
		case 2:
			result = minus(4,5);
			System.out.println(result);
			break;
		case 3:
			result = mul(4,5);
			System.out.println(result);
			break;
		case 4:
			result = div(4,5);
			System.out.println(result);
			break;
		default:
			System.out.println("잘못 입력했어요 다시 입력해주세요");
			break;
		}
	}
		
	}

