package score.dto;

public class Score {
	protected int sno;
	protected String sname;
	protected String spassword;
	protected int kor;
	protected int eng;
	protected int math;
	protected float avg;
	protected int total;
	protected String isfail;
	public int getSno() {
		return sno;
	}
	public Score setSno(int sno) {
		this.sno = sno;
		return this;
	}
	public String getSname() {
		return sname;
	}
	public Score setSname(String sname) {
		this.sname = sname;
		return this;
	}
	public String getSpassword() {
		return spassword;
	}
	public Score setSpassword(String spassword) {
		this.spassword = spassword;
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
	public float getAvg() {
		return avg;
	}
	public Score setAvg(float avg) {
		this.avg = avg;
		return this;
	}
	public int getTotal() {
		return total;
	}
	public Score setTotal(int total) {
		this.total = total;
		return this;
	}
	public String getIsfail() {
		return isfail;
	}
	public Score setIsfail(String isfail) {
		this.isfail = isfail;
		return this;
	}

	
}
	
	
