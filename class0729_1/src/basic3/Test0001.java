package basic3;

public class Test0001 {
	
	public static void sub(int a) {}
	
	public static void ttt(Point b) {}
	
	public static void sss(Point[] a) {
		
		/*for(int i = 0; i<3; i++) {
			a[i].setX((int)(Math.random()*10));
			a[i].setY((int)(Math.random()*10));
			
			String result = a[i].getXY();	
			System.out.println(result);*/
			for(int i = 0; i<a.length; i++)
			{System.out.println(a[i].getXY());
			}
			}
	
	public static void main(String[] args) {
		sub(4);
		Point[] p = new Point[3];
		Point p1= new Point(100,100);
		Point p2= new Point(140,50);
		Point p3= new Point(200,100);
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		Point a = new Point();
		ttt(a);
		sss(p);
	}
}
/*	Point b = new Point();
		String result = b.getXY();
	
		return result;*/