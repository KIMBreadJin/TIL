package basic2;

public class Buyer{//고객 물건 사는사람
	private int money = 1000;
	private int bonusPoint = 0;
	private Product[] item = new Product[10]; // 구매한 제품을 저장하기 위한 객체 배열
	int i=0;
	
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
		item[i++] = p;//제품을 Product 객체 배열에 추가
		System.out.println(p+"을/를 구매하셨습니다.");
	}
	public void summary() { // 구매한 물품을 정보를 보여준다
		int sum=0; //구입한 물건의 가격의 합계
		String itemList="";//구입한 물품 목록
		
		//반복문을 이용하여 구입한 물품의 총 가격의 목록을 만든다
		for(int i = 0; i<item.length; i++) {
			if(item[i] == null) break;
			sum+=item[i].getPrice();
			itemList += item[i] +",";
		}
		System.out.println("구입하신 물건의 총 금액은" + sum+" 입니다.");
		System.out.println("구입하신 제품을 " + itemList + " 입니다.");
	}
}
