package basic;


public class Calculator {
	private int[] scores;
	private float total;
	private float avg;
	private String grade;
	
	public int[] getScores() {
		
		return this.scores;
	}
	public void setScores(int[] scores){
		this.scores= scores;
		
	}
	public float getTotal() {
		return this.total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvg() {
		return this.avg;
	}
	public void setAvg(float avg) {
		this.avg=avg;
	}
	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	

	
	public Calculator() {
		
	}
	public Calculator(String scores) {
		
	}
	
	
	public Calculator(int [] scores) {
		this.scores = scores;
	}
      
	
	
	public float avg(int [] scores) {
		int sum = 0;
		for(int i = 0; i <scores.length; i++) {
			sum+=scores[i];
		}
		return sum/3f;
	}
	
	public String grade(float avg) {
		String result = "";
		if(avg >= 90) {result ="수";}
		else if(avg >= 80) {result = "우";}
		else if(avg >= 80) {result = "미";}
		else if(avg >= 80) {result = "양";}
		else {result = "가";}
		return result;
	}

	
	
}
	