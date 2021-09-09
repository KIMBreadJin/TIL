package basic;

public class Product {
	private int price; // 제품의 가격
	private int bonusPoint; // 제품 구매시 보너스 점수
	Product(int price){
		this.price = price;
		bonusPoint=(int)(price/10.0);// 제품가격의 10% 보너스 점수
	}
	
	public int getPrice() {return this.price;}
	public int getBonusPoint() {return this.bonusPoint;}
	
	public void setPrice(int a) {this.price=price;}
	public void setBonusPoint(int bonusPoint) {this.bonusPoint=bonusPoint;}
}
