package basic3;

public class ShapeTest {

	public static void main(String[] args) {
		Point[] p = new Point[3];
		Point p1= new Point(100,100);
		Point p2= new Point(140,50);
		Point p3= new Point(200,100);
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		
		Triangle t= new Triangle(p);
		Circle c = new Circle(new Point(150, 150), 50);
		t.draw();
		c.draw();
		
		int[] arr = {1,2,3,4,5};
		
	}

}
