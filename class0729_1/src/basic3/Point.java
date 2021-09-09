package basic3;

public class Point {
	private int x;
	private int y;
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Point() {
		this(0,0);
	}
	public String getXY() {
		return"{" +x +","+y+"}";
	}
}
