package basic;

public class Array01Test2 {

	public static void main(String[] args) {
		int[] scores = new int[3];
		scores[0] = 70;
		scores[1] = 90;
		scores[2] = 95;
		String grade="";
		float total = scores[0]+scores[1]+scores[2];
		float avg = total / 3.0f;
		System.out.println("국어 :"+scores[0]+" 수학 :"+scores[1]+ " 영어 :"+scores[2]);
		System.out.println("총합 :"+total+" 평균 :"+avg);
		
		if(avg>=90) grade = "수";
		else if(avg>=80) grade = "우";
		else if(avg>=70) grade = "미";
		else if(avg>=60) grade = "양";
		else if(avg>=50) grade = "가";
		System.out.println("당신의 등급은 " + grade + "입니다.");
		
	}

}
