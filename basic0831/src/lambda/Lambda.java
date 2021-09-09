package lambda;

public class Lambda {
	static void execute(MyFunction f){
		f.run();
	}
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
		}
	static void exgreen(GreenFunction g){
		g.fast();
	}
	static GreenFunction getGreenFunction() {
		GreenFunction g = () -> System.out.println("g1.fast()");
		return g;
		}
		
	
	public static void main(String[] args) {
		//람다식으로 MyFunction의 run()구현
		MyFunction f1 = () -> System.out.println("f1.run()");
		//익명클래스(이름없는 크래스)로 run() 구현
		MyFunction f2 = new MyFunction() {//추상메서드를 가진 클래스를 바로 객체 생성 불가능
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction();
		GreenFunction g1 = () -> System.out.println("g1.fast()");
		GreenFunction g2 = new GreenFunction() {
			@Override
			public void fast() {
				System.out.println("g2.fast()");
			}
		};
		GreenFunction g3 = getGreenFunction();
		
		f1.run(); // 함수가 하나밖에 없으므로  호출이 하나인 메서드 호출 가능
		f2.run();
		f3.run();
		execute(f1);
		execute(() -> System.out.println("run()"));
		
		g1.fast();
		g2.fast();
		g3.fast();
		exgreen(g1);
		exgreen(()->System.out.println("fast()"));
		
		
		
	}

}
