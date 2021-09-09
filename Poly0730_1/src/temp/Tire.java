package temp;

public class Tire {
	private int manufacturer; //제조사
	private String color;		// 색상
	private String position;	// 공장의 위치
	private int weight; 
	private boolean fail;
	
	//getter, setter(함수) => member변수의 값을 읽고 쓰는 함수
	public int getManufacturerm() {
		return this.manufacturer;
	}
	public String getColor() {
		return this.color;
	}
	public String getPosition() {
		return this.position;
	}
	public int getWeight() {
		return this.weight;
	}
	public boolean getFail() {
		return this.fail;
	}

	
	
	void setColor(String color) {
		this.color=color;
	}
	void setManufacturer(int manufacturer) {
		this.manufacturer=manufacturer;
	}
	void setPosition(String position) {
		this.position=position;
	}
	void setWeight(int weight) {
		this.weight=weight;
	}
	void setFail(boolean fail) {
		this.fail=fail;
	}
	//메서드(함수) => isFail
	public boolean isFail(int a) {
		if (weight >70 && weight < 90) return true;
		else return false;
	}
	@Override
	public String toString() {
		return "Tire [color=" + color + ", position=" + position + ", weight=" + weight + "]";
	}
	
	//무게가 70g 보다 크고 90g보다 작으면 true(정상), false(불량 타이어)
}
