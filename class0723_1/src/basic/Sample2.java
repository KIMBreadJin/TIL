package basic;

import java.util.Scanner;

public class Sample2 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();//해결 
		Calculator calc2 = new Calculator(5);
		Calculator calc3 = new Calculator();
		Calculator[] calcs = new Calculator[3];
		calcs[0] =calc;
		calcs[1] =calc2;
		calcs[2] =calc3;
		
		//키보드로 국어 영어 수학 점수를 입력으로 받아서 
		//Calculator 의 멤버변수 scores 배열에 저장하고 평균 및 총점 , 등급을 출력하세요
		Scanner sc =new Scanner(System.in);
		int scores[] = new int[3]; //이렇게 말고요 그러면 의미가 없어요 
		int cnt=1;
		for(int i=0;i<3;i++) {
			System.out.println("calc 숫자를 입력하세요 : " + cnt++);
			scores[i] =sc.nextInt();
		}
		calc.setScores(scores);
		
		System.out.println(calc.getScores());
		/*for(int i=0;i<3;i++) {
			System.out.println("calc2 숫자를 입력하세요 : " + cnt++);
			scores[i] =sc.nextInt();
		}
		
		calc2.setScores(scores);
		
		for(int i=0;i<3;i++) {
			System.out.println("calc3 숫자를 입력하세요 : " + cnt++);
			scores[i] =sc.nextInt();
		}
		calc3.setScores(scores);
		//김강우/오동소님은 동일한 방법으로 해결함 
		//선우세옹/권태수 ,이혜원 ,정희주 */
		

	}
}
