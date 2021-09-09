package basic2;

public class ShapeTest {

	public static void main(String[] args) {
		Point[] p = {
				new Point(100,100),
				new Point(140,50),
				new Point(200,100)
		};
		
		Triangle t= new Triangle(p);
		Point p3 = new Point();
		Circle c = new Circle();
		
		Tire hong = new Tire();
		hong.setColor("빨강");
		hong.setPosition("서울");
		hong.setWeight(70);
		hong.setFail(true);
		
		Tv tv = new Tv();
		tv.setChannel(123);
		tv.setColor("노랑");
		tv.setPower(false);
	
		c.setCenter(p3);
		p3.setX(150);
		p3.setY(100);
		
		c.setTv(tv);
		c.setHong(hong);
		
		t.draw();
		c.draw();
		System.out.println(c.getTv());
	
		System.out.println(c.getHong());
	
	}

}
