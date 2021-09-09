package test;

public class Green {
	private int tire;
	private int driver;
	private int window;
	private String name="";
	
	public Green() {}
	public Green(String name, int tire, int driver, int window) 
	{this.name=name; this.tire=tire; this.driver=driver; this.window=window;}
	public int getTire() {
		return tire;
	}
	public void setTire(int tire) {
		this.tire = tire;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public int getWindow() {
		return window;
	}
	public void setWindow(int window) {
		this.window = window;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
