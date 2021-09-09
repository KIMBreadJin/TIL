package basic;

import java.util.Scanner;
public class WhileAndDoWhile8 {
	public static float getTotal(int[] inputArr) {
		int sum = 0;
		int avg =0;
		for(int i=0; i<5; i++) {
			
			sum += inputArr[i];
		
		}	
		avg = sum/5;
		inputArr[4]=9;
		inputArr[2]=19;
		return avg;
	}
	public static void main(String[] args) {
		int[] inputArr2 = {1,2,3,4,5};
		float avgResult = getTotal(inputArr2);
		for(int i : inputArr2) System.out.println(i);
		System.out.println(avgResult);
		}
	}
		//문제3) while문을 이용하여 3의 배수의 합과 그것의 갯수를 구하고
		//3의배수가 아닌것들의 합을 구하고 3의배수가 아닌것이 볓개인가?
	
		
	
		
