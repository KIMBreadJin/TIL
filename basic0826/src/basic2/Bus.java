package basic2;

import java.util.ArrayList;
import java.util.List;

public class Bus {
	//문제 2)  Bus 클래스 생성
	//메버변수 daegu(정수) ,seoul(정수), 실수( pohang)
	private int daegu;
	private int seoul;
	private float pohang;
	private List<Integer> jeju =new ArrayList<>();
	private List<Car> junju = new ArrayList<>();
	//getter,settet생성
	public int getDaegu() {return this.daegu;}
	public int getSeoul() {return this.seoul;}
	public float getPohang() {return this.pohang;}
	public List<Integer> getJeju(){return this.jeju;}
	public List<Car> getJunju(){return this.junju;}
	
	public void setDaegu(int daegu) {this.daegu=daegu;}
	public void setSeoul(int seoul) {this.seoul=seoul;}
	public void setPohang(float pohang) {this.pohang=pohang;}
	public void setJeju(List<Integer> jeju) {this.jeju= jeju;}
	public void setJunju(List<Car> junju) {this.junju= junju;} 
	//문제 3) 메서드 생성  wireframe => 기능 : Car객체를 파라미터로 받아서 
	// 파라미터의 멤버변수  daegu에 tire 값의 3배을 저장하고
	//seoul에 green의 값의 5배하여 저장함 
	// 반환값은 멤버변수 jeju의 총합을 반환함
	public int wireframe(Car a) {
		int sum=0;
		this.daegu = a.getTire()*3;
		this.seoul = a.getGreen()*5;
		for(int i :jeju) sum+=i;
		return sum;
	}
}
