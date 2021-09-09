package basic;

public class DoWhile {

	public static void main(String[] args) throws java.io.IOException{
		int input=0;
		System.out.println("문장을 입력하세요");
		System.out.println("입력을 마치려면 x를 입력하세요");
		do {
			input= System.in.read();
			System.out.println((char) input);
		}while(input!=-1 && input !='x');
		System.out.println("프로그램이 종료되었습니다.");
		
		//Exception(예외) = > Error랑 비슷하다고 생각하세요 아직 몰라도 됩니다.
	
		int[] arr = {1,2,3};
		//arr[4] = 7; // Exception(예외 발생함)
		//for, while(비교를 하고 참일 경우만 반복), do~while (무조건 한번은 실행을 하고 비교를 함)
		int test=5;
		while(test <=5) {
			System.out.println("테스트");
			test++;
		}
		System.out.println("테스트 종료");
	}

}
