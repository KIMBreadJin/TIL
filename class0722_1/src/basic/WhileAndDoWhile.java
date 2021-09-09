package basic;

public class WhileAndDoWhile {

	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int[] arr = new int[20];
		//arr 스택의 메모리 공간 heap에 있는 메모리 시작 번지를 가리키고 있음
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		
		
		//구구단
		while(a<=9) {
			while(b<=9) {
			System.out.println(a+"x"+b+"="+(a*b));
			b++;
			}
			b=1;
			a++;
			System.out.println("---------");
		}
		}

}
