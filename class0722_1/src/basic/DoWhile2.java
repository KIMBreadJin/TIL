package basic;

public class DoWhile2 {

	public static void main(String[] args) {
		//arr[4] = 7; // Exception(예외 발생함)
		//for, while(비교를 하고 참일 경우만 반복), do~while (무조건 한번은 실행을 하고 비교를 함)
		int test=5;
		while(test <=5) {
			System.out.println("테스트");
			test++;
		}
		System.out.println("테스트 종료");
		do {
			System.out.println("테스트2");
			test++;
		}while(test<=7);
	}

}
