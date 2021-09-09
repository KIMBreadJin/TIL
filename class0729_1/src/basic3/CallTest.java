package basic3;

public class CallTest {
	
	public static void a (String b) {//함수의 정의 , 호출되는 대상
		System.out.println(b);
	}
	public static void tt (String z,int u) {//함수의 정의 , 호출되는 대상
		System.out.println(z + u);
	}
	public static void main(String[] args) {
		
		a("홍길동"); // 함수 호출 및 실행 , 호출하는곳
		tt("홍말자" , 6);
		
}
}
