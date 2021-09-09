package basic3;

public class Circle extends Shape {
	private Point center; // 원의 원점좌표
	private int r;
	
	public Point getCenter() {return this.center;}
	public int getR() {return this.r;}
	
	public void setCenter(Point center) {this.center=center;}
	public void setR(int r) {this.r=r;}
	
	Circle(){
		this(new Point(0,0), 100);
	}
	public Circle(Point center, int r) {
		this.center=center;
		this.r=r;
	}
	
	@Override
	
	void draw() {
		System.out.printf("[center = {%d, %d}, r = %d , color =%s]\n", 
				center.getX(), center.getY(),this.r, color);
		
	}

}
