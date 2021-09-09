package basic;

public class Array01Test {

	public static void main(String[] args) {
		int korea=0, math=0, eng=0;
		korea = 70;
		math = 60;
		eng = 45;
		String grade="";
		float total = korea + math + eng;
		float avg = total / 3.0f;
		System.out.println("국어 :"+korea+" 수학 :"+math+ " 영어 :"+eng);
		System.out.println("총합 :"+total+" 평균 :"+avg);
		
		if(avg>=90) grade = "수";
		else if(avg>=80) grade = "우";
		else if(avg>=70) grade = "미";
		else if(avg>=60) grade = "양";
		else if(avg>=50) grade = "가";
		System.out.println("당신의 등급은 " + grade + "입니다.");
		
	}

}
