package lambda3;

public class Test {
	public static TireFunction f() {
		return (i,j) -> i+j;
	}
	public void f(TireFunction u) {
		int result = u.sum(20, 70);
		System.out.println(result);
	}
	public static void main(String[] args) {
	TireFunction u = (i,j) -> i+j*210;
	int result = u.sum(23,13);
	System.out.println(result);
	f(u);
	TireFunction qq = f();
	qq.sum(23,17);
	
	TireFunction ananymous = new TireFunction() {
		@Override
		public int sum(int a, int b) {
			System.out.println("여기는 이름없는 클래스로 만든 객체 호출");
			return a*3 + b*2 +100;
		}
	};
	result = ananymous.sum(12, 16);
	System.out.println(result);

	}
}
