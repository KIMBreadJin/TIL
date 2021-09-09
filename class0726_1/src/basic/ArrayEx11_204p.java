package basic;

public class ArrayEx11_204p {

	public static void main(String[] args) {
		int[] numArr = new int[10];
		int[] counter = new int[10];
		for(int  i = 0; i<numArr.length; i++) {
			numArr[i] = (int)(Math.random()*10);
			System.out.println(numArr[i]);
		}
		System.out.println();
		for(int i = 0; i<numArr.length; i++) {
			counter[numArr[i]]++;
		}
		for(int i = 0; i<numArr.length; i++) {
			System.out.println(i+"의 갯수는" + counter[i]); 
		}
		int [] cnt = {1, 2 , 3};
		cnt[2]++;//이값은 얼마일까요?
		//cnt 배열의 2번방(index)에 들어있는 값이 무엇인지 모르지만 그 값을 1 증 가시키려면?
		}
	}


