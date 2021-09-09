package basic3;

public class PolyArgumentTest_369p {
	
	public static void main(String[] args) {
		Computer com = new Computer();
		Tv tv1 = new Tv();
		Buyer b= new Buyer();
		Audio Au = new Audio();
		b.buy(tv1);
		b.buy(com);
		b.buy(Au);
		System.out.println("현재 잔액은 " + b.getMoney() + " 원입니다.");
		System.out.println("현재 보너스 점수는 " + b.getBonusPoint()+"점입니다.");
		b.refund(tv1);
		b.refund(com);
		b.summary();
	

	}
}
	
	


