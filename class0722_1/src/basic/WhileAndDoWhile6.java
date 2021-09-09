package basic;

import java.util.Scanner;

public class WhileAndDoWhile6 {
	public static void main(String[] args) {
		int cnt1=0;
		int cnt2=0;	
		int sum1 =0;
		int sum2 =0;
		int sum = 0;
		int avg =0;
		Green green =new Green();
		Green green1=new Green(5);
		Green green2=new Green(3.4f,2,true);
		Green green3=new Green(5,6,"홍말자");
		
		int[] arr = new int[20];
		boolean [] arrBool = new boolean[20];
		//arr 스택의 메모리 공간 heap에 있는 메모리 시작 번지를 가리키고 있음
		
		
		String driver = green3.getDriver();
		//System.out.println(driver +"창문의 갯수 : " + green3.getWindow(),"타이어 갯수: ", + green3.getTire());
		System.out.println("1)창문 2)타이어 3)운전자이름");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
	
		switch(input) {
		case 1:
			System.out.println("창문의 갯수 :"+green3.getWindow());
			break;
		case 2:
			System.out.println("타이어 갯수 :"+green3.getTire());
			break;
		case 3:
			System.out.println("운전자 이름 :"+driver);
			break;
		}
		int[] inputArr = new int[5];
		for(int i=0; i<5; i++) {
			System.out.println("숫자를 입력하세요"+(i+1));
			inputArr[i] = sc.nextInt();
			sum += inputArr[i];
		
		}	avg = sum/5;
		System.out.println("평균 :"+ avg +"입니다.");
	}
}
		//문제3) while문을 이용하여 3의 배수의 합과 그것의 갯수를 구하고
		//3의배수가 아닌것들의 합을 구하고 3의배수가 아닌것이 볓개인가?
	
		
	
		
