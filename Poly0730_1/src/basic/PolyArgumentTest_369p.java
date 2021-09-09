package basic;

public class PolyArgumentTest_369p {
	
	public static void bbb(Buyer b) {
	}
	public static void ttt(Product tt) {}
	
	public static void main(String[] args) {
		Computer com = new Computer();
		Tv tv1 = new Tv();
		Buyer b= new Buyer();
		b.buy(tv1);
		b.buy(new Computer());
		System.out.println("현재 잔액은 " + b.getMoney() + " 원입니다.");
		System.out.println("현재 보너스 점수는 " + b.getBonusPoint()+"점입니다."); 
		bbb(b);
		ttt(tv1);
		ttt(com);
		Product[] pp = new Product[10];
		pp[0] = new Computer();
		pp[1] = new Tv(); // 다형성
	}
}
	
	


