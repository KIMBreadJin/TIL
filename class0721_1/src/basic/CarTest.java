package basic;

public class CarTest {

	public static void main(String[] args) {
		/*Car a =new Car();
		a.driving();
		Car b = new Car();
		b.driving();
		
		float ni;
		Calculator y = new Calculator();
		ni = y.getAvg(90,70,80);
		
		Calculator x = new Calculator();
		x.getGrade(ni);
		
		a.setDriverName("홍길동");
		System.out.println(a.getDriverName());
		*/
		int score=0;
		Calculator calc = new Calculator();
		calc.setKorea((int)(Math.random()*100));
		System.out.println("국어점수" + calc.getKorea());
		calc.setMath((int)(Math.random()*100));
		System.out.println("수학점수" + calc.getMath());
		calc.setEng((int)(Math.random()*100));
		System.out.println("영어점수" + calc.getEng());
		calc.setAvg(calc.getTotal());
		System.out.println(calc.getAvg());
		calc.getGrade(calc.getAvg());
		calc.good(calc.getAvg());
		
		//국어 영어 수학점수를 임의로 넣고 그 평균을 더하고 그평균이 등급을 구하라
		
	}
}
