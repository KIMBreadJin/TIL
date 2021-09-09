package basic4;

public class Test {
	
	public static void main(String[] args) {
		Player a = new GreenPlayer();
		Player b = new RedPlayer();
		GreenPlayer g = new GreenPlaer();
		a.play(7);
		b.play(11);
		Greenable c = new GreenableImpl() ;
		c.driving();
		c.cleaning();
	}
}
