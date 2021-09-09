package basic;

public class Calculator {
	private int total;
	private int avg;
	private String name;
	
	public Calculator() {};	
	public Calculator(int a) {
		this.total=a;
	};
	public Calculator(float a) {
		this.avg=(int)a;
	};
	public Calculator(float a, boolean b) {
		this.avg=(int)a;
	};
	
	public int getTotal(){return this.total;}
	public int getAvg(){return this.avg;}
	public String getName(){return this.name;}
	
	public void setTotal(int total) {this.total=total;}
	public void setAvg(int avg) {this.avg=avg;}
	public void setName(String name) {this.name=name;}
	

	
	

	public int add(int a, int b, int c) {
		System.out.println(c + "파라미터 정수 2개");
		return a+b;
	}
	
	public long add(long a , long b, int c) {
		System.out.println(c + "파라미터 long 2개");
		return a+b;
	}
	public long add(int [] a,int c) {
		System.out.println(c +"파라미터 정수형 배열 1개");
		long result = 0;
		for(int i =0; i<a.length; i++) result += a[i];
		return result;
	}
	
	public int relationalCar(int i, int j) {
		this.total = i+j;
		this.avg = i*5+j+6;
		this.name = "홍길동" + i + j;
		System.out.println("Car 클래스와 관련된 메서드 호출 (Calculator 클래스) ");
		return i*5+4;
		};
}
