package basic3;

public class Car {
	// 문제 1)  Car 클래스 생성
	//멤버변수 정수 tire,정수 window, 문자열 name, 정수 green
	private int tire;
	private int window;
	private String name;
	private int green;
	
	//getter, setter 생성
	public int getTire() {return this.tire;}
	public int getWindow() {return this.window;}
	public String getName() {return this.name;}
	public int getGreen() {return this.green;}
	
	public void setTire(int tire) {this.tire=tire;}
	public void setWindow(int window) {this.window=window;}
	public void setName(String name) {this.name=name;}
	public void setGreen(int green) {this.green=green;}
	
	
}
