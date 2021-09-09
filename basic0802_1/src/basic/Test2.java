package basic;

public class Test2 {
	private String papa;
	private String mama;
	private String address;
	private int number;
	private boolean marry;
	private int addnum;
	
	public String getPapa() {
		return papa;
	}
	public void setPapa(String papa) {
		this.papa = papa;
	}
	public String getMama() {
		return mama;
	}
	public void setMama(String mama) {
		this.mama = mama;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isMarry() {
		return marry;
	}
	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	public int getAddnum() {
		return addnum;
	}
	public void setAddnum(int addnum) {
		this.addnum = addnum;
	}
	
	public String point(String a) {
		switch(a) {
		case "서울시" :
			this.addnum = 1;
			break;
		case "부산시" :
			this.addnum = 2;
			break;
		case "대구시" :
			this.addnum = 3;
			break;
		case "경상북도" :
			this.addnum = 4;
			break;
		case "경상남도" :
			this.addnum = 5;
			break;
		case "전라북도" :
			this.addnum = 6;
			break;
		case "전라남도" :
			this.addnum = 7;
			break;
		case "충청북도" :
			this.addnum = 8;
			break;
		case "충청남도" :
			this.addnum = 9;
			break;
		default :
			this.addnum = 10;
			break;
	}
	return this.papa +" "+a;

}
}
