package basic;

public class ArrayFunctionTest {

	public static int arrayClac(int a) {
			int result=0;	
			if(a%2==1) {
				result = a * 2;
			}
			else 
				result = a * 3;         //파라미터로 받은 값이 3의 배수이면 4배하고 그렇지 않으면 5배한 결과를 반환함
		return result;
	}
	
	public static void main(String[] args) {
		int result =0;
		int total = 0;
		int[] arr= new int[100];
		
		for(int i = 0;i<100;i++) {
			arr[i]=(int)(Math.random()*100) +1;
			result = arrayClac(arr[i]);
			System.out.println(result);
		}
		for(int i = 0; i<100; i++) {
			if (result%3==0)
				total = result *= 4;
			else 
				total = result *= 5;
			
			
		}
		System.out.println(total);
}
}

	
	//문제 1) arr배열에 random한 1~100까지의 숫자를 저장하시오
		//문제 2) 그 배열에 저장 되어 있는 값이 홀수 이면 arrayCalc호출시 2배를 하여 값을 전달하고
		// 그배영에 저장되어 있는 값이 짝수이면 arrayCalc 호출시 3배를 하여 값을 파라미터로 전달함
		//전체 100개의 데이터를 반복문으로 이용하여 arrayCalc에서 호출시 반환되는 값의 총합을 구하세요