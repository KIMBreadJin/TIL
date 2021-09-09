package basic;

import java.util.Scanner;

public class Nesredlf {
	public static String getGrade(int a) {
		int score = a;
		String grade="";
		
		if(score >=90) {
			grade="A";
			if(score >= 98) {
				grade +="+";				
			}
			else if (score <94) {
				grade += "-";
			}
		}
		else if (score >= 80) {
			grade = "B";
			if (score>=80) {
				grade += "+";
			}
			else if (score < 84) {
				grade += "-";
			}
		}
		else {
			grade = "C";
		}
		return grade;
	}
	
	

	public static void main(String[] args) {
		
		int score=0;
		
		String grade="";
		Scanner a = new Scanner(System.in);
		System.out.println("점수를 입력하시면 등급을 알려줍니다.");
		score = a.nextInt();
		
		grade = getGrade(score);
		
		System.out.println("당신의 학점은 " + grade + "입니다.");

	}
}
 