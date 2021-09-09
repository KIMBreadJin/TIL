package basic;

import java.util.Scanner;

public class Scannerinput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 외울것
		System.out.println("수학 점수를 입력하세요");
		int korea = sc.nextInt(); // 정수를 키보드로 입력받아라
		System.out.println(korea);
		
		
		System.out.println("국어 점수를 입력하세요");
		int math = sc.nextInt(); // 정수를 키보드로 입력받아라
		System.out.println(math);
		
		
		System.out.println("영어 점수를 입력하세요");
		int eng = sc.nextInt(); // 정수를 키보드로 입력받아라
		System.out.println(eng);
		
		System.out.println("당신의 총점은 : " + (korea+math+eng));
	}

}
