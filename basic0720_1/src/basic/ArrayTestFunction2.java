package basic;

import java.util.Scanner;

public class ArrayTestFunction2 {

	public static int arraySum(int a) {
		return a*2;
	}
	public static void main(String[] args) {
		int arr[] = new int[100];
		int sum = 0;
		System.out.println("원하시는 숫자를 입력하시오");
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		for(int i = 0; i<100; i++) {
			arr[i] = (int)(Math.random()*100);
			
			if(arr[i]%n==0) {
				arraySum(arr[i]);
				sum += arraySum(arr[i]);
			}	
		}
		System.out.println("3에 배수인 것에 arraySum 총합 : " + sum);
	}
}


//for(int i=1;i<100;i++) System.out.println(arr[i]);
//문제 랜덤하게 들어가 있는 arr배열의 데이터가 3의 배수인것만 골라서
//arraySum함수에 파라미터(인자) 로 전달하고 반환되는 값들을 누적한 결과 출력
//키보드로 입력받은 데이터의 배수인것들만 함수 호출하 고 그 호출되어 반환된 값들의 누적값을 구하세요