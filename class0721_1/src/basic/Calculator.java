package basic;

public class Calculator {
	private int korea;
	private int math;
	private int eng;
	private int total;
	private float avg;
	
	int getKorea() {
		return this.korea;
	}
	int getMath() {
		return this.math;
	}
	int getEng() {
		return this.eng;
	}
	int getTotal() {
		return this.getKorea()+getEng()+getMath();
	}
	float getAvg() {
		return this.getTotal()/3.0f;
	}
	
	void setKorea(int korea) {
		this.korea=korea;
	}
	void setEng(int eng) {
		this.eng=eng;
	}
	void setMath(int math) {
		this.math=math;
	}
	void setTotal(int total) {
		this.total=total;
	}
	void setAvg(float avg) {
		this.avg=avg;
	}
	public float getAvg(int korea, int math, int eng) {
		return (korea+math+eng)/ 3.0f;
		
	}
	public String getGrade(float avg) {
		String grade = "";
		if(avg>=90 )grade = "수";
		else if(avg>=80) grade = "우";
		else if(avg>=70) grade = "미";
		else if(avg>=60) grade = "양";
		else grade = "가";
		
		System.out.println("당신의 등급은 "+grade+" 입니다");
		
		return grade;
	}
	public boolean good(float avg) {
		boolean nice;
		if (avg>=80) {
			nice = true;
			System.out.println("합격입니다.");
		}
		else {
			nice = false;
			System.out.println("불합격입니다.");
		}
		return nice;
			
	}
}
