package basic;

public class TvTest3 {

	public static void main(String[] args) {
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		Tv tv3 = new Tv();
		Tv tv4 = new Tv();
		Tv tv5 = new Tv();
		
		tv1.setChannel(10);
		tv1.setColor("빨강");
		tv1.setPower(true);
		
		tv2.setChannel(15);
		tv2.setColor("노랑");
		tv2.setPower(true);
		
		tv3.setChannel(30);
		tv3.setColor("초록");
		tv3.setPower(false);
		
		tv4.setChannel(110);
		tv4.setColor("보라");
		tv4.setPower(true);
		
		tv5.setChannel(1900);
		tv5.setColor("똥색");
		tv5.setPower(false);
		
		System.out.println("tv1 객체의 채널은 " + tv1.getChannel());
		

		
	}

}
