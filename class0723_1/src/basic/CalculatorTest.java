package basic;

import java.util.Scanner;

public class CalculatorTest {

public static void main(String[] args) {
		
		Calculator [] calcs = new Calculator[100];
		
		for(int i = 0; i <calcs.length; i++) {
			calcs[i]= new Calculator();
		}
		
		int sum =0;
		int [] scores = new int[3];
		float result = 0.0f;
		String grade = "";
		
		for(int a = 0; a < calcs.length; a++) {
			for(int i = 0; i < 3; i++) {			
				
				scores[i] = (int)(Math.random()*100)+1;
				sum+=scores[i];
			    
			}
			
			calcs[a]=new Calculator(scores);
			calcs[a].setScores(scores);
			calcs[a].getScores();
			result = calcs[a].avg(scores);
			calcs[a].setAvg(result);
			grade = calcs[a].grade(result);
			calcs[a].setGrade(grade);
			
			
			System.out.println("평균: "+calcs[a].getAvg()+"등급: "+calcs[a].getGrade());
			
		}
	}

		//키보드로 국어 영어 수학 점수를 입력받아서
		//Calculator 의 멤버변수 스코어 배열에 저장하고 몇균 및 총점 , 등급을 출력
}
