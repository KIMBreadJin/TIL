package basic;

import java.util.Scanner;
public class WhileAndDoWhile7 {
	public static float getTotal(int[] inputArr) {
		int sum = 0;
		int avg =0;
		for(int i=0; i<5; i++) {
			
			sum += inputArr[i];
		
		}	avg = sum/5;
		return avg;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inputArr = new int[5];
		for(int i=0; i<5; i++) {
			System.out.println("숫자를 입력하세요"+(i+1));
			inputArr[i] = sc.nextInt();
		}
		float avgResult = getTotal(inputArr);
		System.out.println("평균 :"+ avgResult +"입니다.");
	}
}
		//문제3) while문을 이용하여 3의 배수의 합과 그것의 갯수를 구하고
		//3의배수가 아닌것들의 합을 구하고 3의배수가 아닌것이 볓개인가?
	
		
	
		
