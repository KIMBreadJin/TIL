package basic;

public class CarTest2 {

	private int number;
	private String driverName;
	
	int getNumbe() {
		return this.number;
	}
	String getDrinverName() {
		return this.driverName;
	}
	void setNumber(int number) {
		this.number=number;
	}
	
	void setDriverName(String driverName) {
		this.driverName=driverName;
	}
	public void driving() {
		System.out.println("운전중이에요");
	}
}

//수학점수를 멤버변수를 50점으로 하고, 
//다음 멤버변수의 값을 읽어서 화면에 출력하세요