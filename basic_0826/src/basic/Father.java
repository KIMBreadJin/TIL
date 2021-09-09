package basic;

import java.util.ArrayList;
import java.util.List;

public class Father {
	private int son;
	private int motehr;
	private float daughter;
	private boolean child;
	private List<Integer> goods = new ArrayList<>();
	private List<Integer> product = new ArrayList<>();
	
	public int getSon() {
		return son;
	}
	public void setSon(int son) {
		this.son = son;
	}
	public int getMotehr() {
		return motehr;
	}
	public void setMotehr(int motehr) {
		this.motehr = motehr;
	}
	public float getDaughter() {
		return daughter;
	}
	public void setDaughter(float daughter) {
		this.daughter = daughter;
	}
	public boolean getChild() {
		return child;
	}
	public void setChild(boolean child) {
		this.child = child;
	}
	public List<Integer> getGoods() {
		return goods;
	}
	public void setGoods(List<Integer> goods) {
		this.goods = goods;
	}
	public List<Integer> getProduct() {
		return product;
	}
	public void setProduct(List<Integer> product) {
		this.product = product;
	}
	
	public int insert(int a) {
		this.goods.add(a);
		return a*2;
	}
	public boolean pretty(int a) {
		this.product.add(a*2);
		if(a%2==1) return true;
		else return false;
	}
}
