package basic3;

import java.util.ArrayList;
import java.util.List;

public class Buyer{//고객 물건 사는사람
	private int money = 1000;
	private int bonusPoint = 0;
	private List<Product> item = new ArrayList<Product>(); // 구매한 제품을 저장하기 위한 객체 배열
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
		item.add(p);//제품을 Product 객체 배열에 추가
		System.out.println(p+"을/를 구매하셨습니다.");
	}
	public void refund(Product p) {
		if(item.remove(p)) {
		money += p.getPrice();
		bonusPoint -= p.getBonusPoint();
		System.out.println(p+"을/를 반품 하셨습니다.");
		}
		else
			System.out.println("구입하신 제품중 해당 제품이 없습니다.");
	}
	public void summary() { // 구매한 물품을 정보를 보여준다
		int sum=0; //구입한 물건의 가격의 합계
		String itemList="";//구입한 물품 목록
		
		if(item.isEmpty()) {
			System.out.println("구입하신 물건이 없습니다.");
			return;
		}
		
		//반복문을 이용하여 구입한 물품의 총 가격의 목록을 만든다
		for(int i = 0; i<item.size(); i++) {
			Product p =(Product)item.get(i);
			sum += p.getPrice();
			itemList+=(i==0) ? "" +p : ", " +p;
		System.out.println("구입하신 물건의 총 금액은" + sum+" 입니다.");
		System.out.println("구입하신 제품을 " + itemList + " 입니다.");
	}
}
}
