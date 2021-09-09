package score.dto;

public class Score {
	protected int tno;
	protected String tname;
	protected int kor;
	protected int eng;
	protected int math;
	protected float tavg;
	protected int total;
	protected String grade;
	
	
	
	public String getTname() {
		return tname;
	}
	public Score setTname(String tname) {
		this.tname = tname;
		return this;
	}
	public int getTno() {
		return tno;
	}
	public Score setTno(int tno) {
		this.tno = tno;
		return this;
	}
	public int getKor() {
		return kor;
	}
	public Score setKor(int kor) {
		this.kor = kor;
		return this;
	}
	public int getEng() {
		return eng;
	}
	public Score setEng(int eng) {
		this.eng = eng;
		return this;
	}
	public int getMath() {
		return math;
	}
	public Score setMath(int math) {
		this.math = math;
		return this;
	}
	public float getTavg() {
		return tavg;
	}
	public Score setTavg(float tavg) {
		this.tavg = tavg;
		return this;
	}
	public int getTotal() {
		return total;
	}
	public Score setTotal(int total) {
		this.total = total;
		return this;
	}
	public String getGrade() {
		return grade;
	}
	public Score setGrade(String grade) {
		this.grade = grade;
		return this;
	}
	
	
}
