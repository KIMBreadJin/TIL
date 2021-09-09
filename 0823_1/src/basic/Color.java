package basic;

public class Color {	
	private String green;
	private String red;
	private String blue;
	
	public String getGreen() {
		return green;
	}
	public void setGreen(String green) {
		this.green = green;
	}
	public String getRed() {
		return red;
	}
	public void setRed(String red) {
		this.red = red;
	}
	public String getBlue() {
		return blue;
	}
	public void setBlue(String blue) {
		this.blue = blue;
	}
	@Override
	public String toString() {
		return "green=" + green + ", red=" + red + ", blue=" + blue + "";
	}
	
}
