package basic2;

public class Shape {
	protected String color= "black";
	//접근 제한자
	//public => 어디서든 접근 가능
	//protected => 다른 패키지여도 상속을 받았으면 접근 가능
	//default => 같은 패키지 내에서 접근 가능
	//private => 접근 불가능
	void draw() {
		System.out.printf("{[color\n]", color);
	}
}
