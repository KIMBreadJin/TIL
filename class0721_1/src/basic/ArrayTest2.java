package basic;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car[] cars = new Car[5];
		
		for(int i= 0; i <cars.length; i++) {
			cars[i] = new Car();
		}
		for(int i =0; i<cars.length; i++) {
			cars[i].setDriverName("홍길동" + (int)(Math.random()*20));
			cars[i].setNumber((int)(Math.random()*20));
	}
		for(Car t : cars) {
			System.out.println(t.getDriverName());
			System.out.println(t.getNumber());
		}

}
}
