package basic;

public class if3 {

	public static void main(String[] args) {
		int score = 95;
		if(score>90) System.out.println("A등급");
		else if(score>=80) System.out.println("B등급");
		else if(score>=70) System.out.println("C등급");
		else if(score>=60) System.out.println("D등급");
		else System.out.println("F등급");
		//문제
		//if(score>70 && score>80 && score>60) System.out.println("합격입니다/");
		if (score > 80) System.out.println("합격입니다.");
	}

}
