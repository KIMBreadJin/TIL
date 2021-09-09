package basic;

public class ArrayFunctionTest2 {
	public static void main(String[] args) {
		int[] arr= {3,2,7,7,89};
		boolean[] arrBool = new boolean[5];
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2==0)
				arrBool[i] = true;
			else
				arrBool[i] = false;
			System.out.println(arrBool[i]);
		//문제 11) arr의 배열에 들어 있는 값이 홀수 인지 짝수인지를 판단하고 
		//해당 데이터가 짝수이면 true를 홀수이면 false를 arrBool에 저장하세요
		//arrBool [0] = false
		}
	}
}
