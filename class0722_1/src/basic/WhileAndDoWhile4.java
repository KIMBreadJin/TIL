package basic;

public class WhileAndDoWhile4 {
	
	public static void sumTimes(int a) {//3의배수의 총합
		int sum=0;
		if (a%3==0)
			sum *= a;
		System.out.println("3의 배수의 총합 :" + sum);
	}
	public static void sumTimesX(int a) {//3의배수가 아닌 총합
		int sum=0;
		if (a%3!=0)
			sum *= a;
		System.out.println("3의배수 아닌것의 총합 :" + sum);
		
	}
	public static void cntTimes(int a) {//3의배수의 개수
		int cnt=0;
		if(a%3==0)
			cnt++;
		System.out.println("3의배수 개수" + cnt);
		
	}
	public static void cntTimesX(int a) {//3의배수가 아닌 것의 개수
		int cnt=0;
		if(a%3!=0)
			cnt++;
		System.out.println("3의배수가 아닌것의 개수" + cnt);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[20];
		//arr 스택의 메모리 공간 heap에 있는 메모리 시작 번지를 가리키고 있음
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			sumTimes(arr[i]);
			sumTimesX(arr[i]);
			cntTimes(arr[i]);
			cntTimesX(arr[i]);
			}
			
		}

	}
		//문제3) while문을 이용하여 3의 배수의 합과 그것의 갯수를 구하고
		//3의배수가 아닌것들의 합을 구하고 3의배수가 아닌것이 볓개인가?
	
		
	
		
