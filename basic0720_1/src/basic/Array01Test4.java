package basic;

public class Array01Test4 {

	public static void main(String[] args) {
		int[] ban=new int[100];
		String grade="";
		for(int i = 0;i<100;i++) {
			ban[i]=(int)(Math.random()*100);
		}
		for(int i = 0;i<100;i++) System.out.println(ban[i]);
		
		int total = 0;
		for(int i=0; i<100; i++) {
			total += ban[i];
		}
		float avg = total/100.0f;
		
		System.out.println("총합 : "+total+" 평균 : "+avg);
		
		if(avg >= 90) grade = "수";
		else if(avg >= 80) grade = "우";
		else if(avg >= 70) grade = "미";
		else if(avg >= 60) grade = "양";
		else grade = "가";
		
		System.out.println("등급은 "+grade+" 입니다.");
	}

}
