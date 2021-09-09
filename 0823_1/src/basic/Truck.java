package basic;

import java.util.ArrayList;
import java.util.List;

public class Truck {


	private int tire;
	private int punk;
	private float mikum;
	private boolean jungja;
	private List<Integer> number = new ArrayList<Integer>();
	
	public int getTire() {
		return tire;
	}
	public void setTire(int tire) {
		this.tire = tire;
	}
	public int getPunk() {
		return punk;
	}
	public void setPunk(int punk) {
		this.punk = punk;
	}
	public float getMikum() {
		return mikum;
	}
	public void setMikum(float mikum) {
		this.mikum = mikum;
	}
	public boolean getJungja() {
		return jungja;
	}
	public void setJungja(boolean jungja) {
		this.jungja = jungja;
	}
	public List<Integer> getNumber() {
		return number;
	}
	public void setNumber(List<Integer> number) {
		this.number = number;
	}
	public int getTotal() {
		int sum = 0;
		for(int i : this.number) if(i%3==0) sum += i;
		return sum;
	}
}
