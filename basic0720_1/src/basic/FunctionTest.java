package basic;

public class FunctionTest {

	public static void sub(int a, int b) {//함수의 정의
		System.out.println("서브 함수가 호출되었습니다"+(a+b));
	}
	public static void minus(float a, float b) {//함수의 정의
		System.out.println("마이너스 함수가 호출되었습니다"+(a-b));
	}
	public static int pow(int a, int b) {
		int result = 1;
		for(int i=0; i<b; i++) {
			result *=a;
		}
		return result;
	}
	public static void gugudan(int a) {
		for(int i=1;i<10;i++) {
			System.out.println(a+"*"+i+"="+i*a);
		}
	}
	public static void exchange(int a, int b) {
		int empty = 0;
		System.out.println("a의 값은 " + a + " / b의 값은 " +b);
		empty = a;
		a = b;
		b=empty;
		System.out.println("a의 값은 " + a + " / b의 값은 " +b);
	}

	public static void main(String[] args) {
		/*System.out.println(a + "의 "+ b +"승은 " + result);
		gugudan(2);*/
		System.out.println("2단");
		for(int i=1; i<=9; i++) {
			System.out.println(i+"단");
			gugudan(i);
			
		}
		exchange(4,5);
	}

}
