package basic;

import java.util.Scanner;

public class ReturnBoolean {
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
	public static void temp(int a, int b) {
		int empty;
		empty = a;
		System.out.println("바뀌기 전 "+a +" "+ b);
		a = b;
		b =empty;
		System.out.println("바뀐 후 "+a +" "+ b);
	}
	public static int times() {
		int result=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("몇단을 출력 하시겠습니까 ex)3");
		int gugu = sc.nextInt();
		for(int i=1; i<=9; i++) {
			result = gugu * i;
			System.out.println(gugu + " x " + i + " = " + result);
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 계산이 무엇인가요? 1)더하기 2)빼기 3)곱하기 4)나누기 5)데이터 교환 6)구구단");
		int input = sc.nextInt();
		switch(input) {
		case 1: 
			System.out.println(sum(8,2));
			break;
		case 2:
			System.out.println(minus(8,2));
			break;
		case 3:
			System.out.println(mul(8,2));
			break;
		case 4:
			System.out.println(div(8,2));
			break;
		case 5:
			temp(8,2);
			break;
		case 6:
			System.out.println(times());
			break;
		default:
			System.out.println("잘못 입력하셨어요");
			break;
		}
		
	}

}
