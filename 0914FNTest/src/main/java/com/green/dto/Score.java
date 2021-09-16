package com.green.dto;

public class Score {

	protected int sno;
	protected String sname;
	protected String spassword;
	protected  int korea;
	protected  int math;
	protected int eng;
	protected int total;
	protected float avg;
	protected String isFail;
	
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
	public int getKorea() {
		return korea;
	}
	public Score setKorea(int korea) {
		this.korea = korea;
		return this;
	}
	public int getMath() {
		return math;
	}
	public Score setMath(int math) {
		this.math = math;
		return this;
	}
	public int getEng() {
		return eng;
	}
	public Score setEng(int eng) {
		this.eng = eng;
		return this;
	}
	public int getTotal() {
		return total;
	}
	public Score setTotal(int total) {
		this.total = total;
		return this;
	}
	public float getAvg() {
		return avg;
	}
	public Score setAvg(float avg) {
		this.avg = avg;
		return this;
	}
	public String getIsFail() {
		return isFail;
	}
	public Score setIsFail(String isFail) {
		this.isFail = isFail;
		return this;
	}
	
	
}
