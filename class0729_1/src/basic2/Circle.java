package basic2;

public class Circle extends Shape {
	private Point center; // 원의 원점좌표
	private Tv tv;
	private int r;
	private Tire hong;
	
	public Point getCenter() {return this.center;}
	public int getR() {return this.r;}
	public Tv getTv() {return this.tv;}
	public Tire getHong() {return this.hong;}
	
	public void setCenter(Point center) {this.center=center;}
	public void setR(int r) {this.r=r;}
	public void setTv(Tv tv) {this.tv=tv;}
	public void setHong(Tire hong) {this.hong=hong;}
	
	Circle(){
		//this(new Point(0,0), 100);
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
