package basic;

import java.util.Scanner;

public class Nesredlf2 {
	
	public static String getGrade(int a) {
		int score = a;
		String grade ="";
		if(score >=70)
			grade = "합격";
		else
			grade = "불합격";
		
		return grade;
	
}
	public static void main(String[] args) {
		
	int score=0;
	String grade="";
	System.out.println("점수를 입력 해주세요");
	Scanner a = new Scanner(System.in);
	score = a.nextInt();
	grade = getGrade(score);	
	System.out.println("당신은 "+grade+" 하였습니다");
	//문제 2) 별도의 main 함수를 포함하는 클래스 생성후
	//입력되는 값이 50이상이면 문자열이 아닌 논리 true 를 반환하고 그렇지 못함녀 false를 반환하는 함수를 생성하고
	//main함수에서 위에서 만든 함수를 
	}
}
 