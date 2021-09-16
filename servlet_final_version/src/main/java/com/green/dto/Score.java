package com.green.dto;

public class Score {
	
	private int sno;
	private String sname;
	private String spassword;
	private int korea;
	private int math;
	private int eng;
	private int total;
	private float avg;
	private String isFail;
	
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
