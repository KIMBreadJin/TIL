package basic;

import java.util.Scanner;

public class Switchinput {
	public static void sum() {
		System.out.println("더하기함수");}
	public static void minus() {
		System.out.println("뺴기함수");}
	public static void mul() {
		System.out.println("곱하기함수");}
	public static void div() {
		System.out.println("나누기함수");}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원핫시는 숫자를 입력하세요");
		int input = sc.nextInt();
		switch(input) {
		case 1: sum();
		break;
		case 2: minus();
		break;
		case 3: mul();
		break;
		case 4: div();
		break;
		default:
			System.out.println("잘못 입력하셨어요");
			break;
		}
	}

}
