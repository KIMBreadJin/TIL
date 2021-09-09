package basic;

public class Buyer{//고객 물건 사는사람
	private int money = 1000;
	private int bonusPoint = 0;
	
	public int getMoney() {return this.money;}
	public int getBonusPoint(){return this.bonusPoint;}
	
	public void setMoney(int money) {this.money=money;}
	public void setBonusPoint(int bonusPoint) {this.bonusPoint=bonusPoint;}
	
	public void buy(Product p) {
		if(money<p.getPrice()) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		System.out.println(p+"을/를 구매하셨습니다.");
	}
}
