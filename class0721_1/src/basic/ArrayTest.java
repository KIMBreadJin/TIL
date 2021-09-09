package basic;

public class ArrayTest {

	public static void main(String[] args) {
		Car[] cars = new Car[5];
		Car a = new Car();
		Car b = new Car();
		Car c = new Car();
		Car d = new Car();
		Car f = new Car();
		
		cars[0]=a;
		cars[1]=b;
		cars[2]=c;
		cars[3]=d;
		cars[4]=f;
		for(int i =0; i<cars.length; i++) {
			cars[i].setDriverName("홍길동" + i);
			cars[i].setNumber((i+3)*20);
	}
		for(Car t : cars) {
			System.out.println(t.getDriverName());
			System.out.println(t.getNumber());
		}

}
}
