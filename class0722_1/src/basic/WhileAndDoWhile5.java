package basic;

public class WhileAndDoWhile5 {
	public static void main(String[] args) {
		int cnt1=0;
		int cnt2=0;	
		int sum1 =0;
		int sum2 =0;
		Green green =new Green();
		Green green1=new Green(5);
		Green green2=new Green(3.4f,2,true);
	
		
		int[] arr = new int[20];
		boolean [] arrBool = new boolean[20];
		//arr 스택의 메모리 공간 heap에 있는 메모리 시작 번지를 가리키고 있음
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		for(int i=0; i<arr.length; i++) {
		arrBool[i] = green.sumTimes(arr[i]);
		}
		for(int i=0; i<arrBool.length;i++) {
		if (arrBool[i] = true) 
			cnt1++;
		}
		int i=0;
		while(i < arr.length) {
			if (cnt1%2==0) {
				sum1 += green.sumTrue(arr[i++]);
			}
			else if (cnt1%2 != 0)
				sum2 += green.sumFalse(arr[i++]);
		}
		System.out.println("true인 개수가 짝수일때 총 합은" + sum1);
		System.out.println("true인 개수가 홀수일때 총 합은" + sum2);
		
			
		}

	}
		//문제3) while문을 이용하여 3의 배수의 합과 그것의 갯수를 구하고
		//3의배수가 아닌것들의 합을 구하고 3의배수가 아닌것이 볓개인가?
	
		
	
		
