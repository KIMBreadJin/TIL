package basic2;

public class Triangle extends Shape{
	Point[] p = new Point[3]; // Point 객체를 저장할 공간 3개 확보, 멤버 변수, 포함관계
	Triangle(Point[] p) {
		this.p = p;
	}
	@Override
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color =%s]\n",
				p[0].getXY(),p[1].getXY(),p[2].getXY(),color);
	}
	

}
