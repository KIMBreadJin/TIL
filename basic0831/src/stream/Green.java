package stream;

public class Green {
	// 문제 1)  Green 클래스 생성 ,멤버변수 정수형( math, eng,korea,total)
	private int math;
	private int eng;
	private int korea;
	private int total;
	//getter setter 생성
	public int getMath() {return this.math;}
	public int getEng() {return this.eng;}
	public int getKorea() {return this.korea;}
	public int getTotal() { return this.total;}
	
	public void setMath(int math) {this.math= math;}
	public void setEng(int eng) { this.eng= eng;}
	public void setKorea(int korea) { this.korea = korea;}
	public void setTotal(int total) { this.total= total;}
	// method greaterThan =>파라미터 1(국어) 2(영어) 3(수학) ,4 (총점)
	// 국어영어수학의  총합이 총점보다 크면 true 반환 그렇지 않으면 false 반환 
	public boolean greaterThan(int korea, int math, int eng,int total) {
		if((korea+math+ eng)>total) return true;
		else return false;
	}
	public Green(int math, int eng, int korea, int total) {
		super();
		this.math = math;
		this.eng = eng;
		this.korea = korea;
		this.total = total;
	}
	
			
}
