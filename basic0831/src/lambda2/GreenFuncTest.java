package lambda2;

public class GreenFuncTest {
	public static GreenFunction f() {
		return (i) -> System.out.println("나는 함수객체를 반환하는 놈 : " +i+"를가짐");
	}
	public static void f(GreenFunction u) {
		u.run(7);
	}
	
	public static void main(String[] args) {
		GreenFunction f1 = (i) -> System.out.println("파라미터로 전달되는 값은 " + i);
		f1.run(5);
		f1 = f();
		f1.run(15);
		f((i) -> System.out.println("나는 다른 함수에 호출되는 놈이야 " + i + "를 가지고요"));
		
		f1 = new GreenFunction() {
			@Override
			public void run(int a) {
				System.out.println("나는 이름없는 익명 클래스 만들어 진 놈"+a+"를 가짐");
			}
		};
		f1.run(123);
	}
}
