package basic;

public class Overloading {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Calculator z = new Calculator(11);
		Calculator u = new Calculator(11f);
		Calculator uu = new Calculator(11f,true);
		System.out.println(z.getTotal());
		System.out.println(u.getAvg());
		System.out.println(uu.getAvg());
		System.out.println(uu.getTotal());
		int i=1;
		int first = calc.add(3,6,i++);
		System.out.println("first 값은 : "+first);
		long second = calc.add(3L, 7L,i++);
		System.out.println("second 값은 :" + second);
		int[] tt = {1,2,3,4,5};
		calc.add(tt,i++);
		
		Car b = new Car();
		Car c = new Car(11);
		int re = calc.relationalCar(first, (int)second);
		System.out.println("계산기 객체의 멤버변수인 relationalCar의 반환값은 "+re);
		b.setNumber(re);
		System.out.println("자동차 멤버변수 넘버의 값음" + b.getNumber());
		calc.setAvg(10);
		System.out.println("계산기 객체의 멤버변수 평균값은 : " + calc.getAvg());
		System.out.println("계산기 객체의 멤버변수 총점값은 : " + calc.getTotal());
		System.out.println("계산기 객체의 멤버변수 이름은 : " + calc.getName());
	}
}
