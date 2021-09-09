package basic;

public class WhileAndDoWhile3 {
	public static void main(String[] args) {

		int cnt =0;
		int sum = 0;
		int cnt2 =0;
		int sum2 =0;
		int[] arr = new int[20];
		//arr 스택의 메모리 공간 heap에 있는 메모리 시작 번지를 가리키고 있음
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			while(arr[i] % 3==0) {
				sum += arr[i];
				cnt++;
				break;
			}
			while(arr[i]% 3!= 0) {
				sum2 += arr[i];
				cnt2++;
				break;
			}
		}
		System.out.println("총합은"+sum+"개수는"+cnt);
		System.out.println("총합은"+sum2+"개수는"+cnt2);
	}
}
		//문제3) while문을 이용하여 3의 배수의 합과 그것의 갯수를 구하고
		//3의배수가 아닌것들의 합을 구하고 3의배수가 아닌것이 볓개인가?
	
		
	
		
