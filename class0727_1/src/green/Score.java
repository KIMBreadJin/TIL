package green;

public class Score {
	private int korea;
	private int math;
	private int eng;
	private float total;
	private float avg;
	private String grade;
	private String name;
	
	int getKorea() {
		return this.korea;
	}
	int getMath() {
		return this.math;
	}
	int getEng() {
		return this.eng;
	}
	float getTotal() {
		return this.getKorea()+getEng()+getMath();
	}
	float getAvg() {
		return this.getTotal()/3.0f;
	}
	String getName() {
		return this.name;
	}
	String getGrade() {
		return this.grade;
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
	void setTotal(float total) {
		this.total=total;
	}
	void setAvg(float avg) {
		this.avg=avg;
	}
	void setName(String name) {
		this.name=name;
	}
	void setGrade(String grade) {
		this.grade=grade;
	}
		
	public String calcGrade(float avg) {
		String grade = "";
		if(avg>=90 )grade = "수";
		else if(avg>=80) grade = "우";
		else if(avg>=70) grade = "미";
		else if(avg>=60) grade = "양";
		else grade = "가";
		
		//System.out.println("당신의 등급은 "+grade+" 입니다");
		
		return grade;
	}

}
