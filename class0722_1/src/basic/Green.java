package basic;

public class Green {
	private int tire;
	private int window;
	private String driver;
	
	public Green () {}
	
	public Green (int a) {
	}
	public Green (float b,int a ,boolean cc){	
	}
	
	public Green(int tire, int window, String driver) {
		this.tire = tire;
		this.window = window;
		this.driver = driver;
	}
	public int getTire() {
		return this.tire;
	}
	public int getWindow() {
		return this.window;
	}
	public String getDriver() {
		return this.driver;
	}
	public void setTire(int tire) {
		this.tire=tire;
	}
	public void setWindow(int window) {
		this.window=window;
	}
	public void setDriver(String driver) {
		this.driver=driver;
	}
		
	public static boolean sumTimes(int a) {//3의배수의 총합
		if(a%3==0)
			return  true;
		else
			return false;
	}
	public static int sumTrue(int a) {
		return a*5;
	}
	public static int sumFalse(int a) {
		return a*15;
	}

}
