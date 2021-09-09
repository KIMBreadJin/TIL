package basic;

public class TvTest2 {

	public static void main(String[] args) {
		Tv tv[] = new Tv[5];
		
		int[] chanl ={10, 15, 30, 110, 1900};
		String[] clor ={"빨강", "노랑", "초록","보라","똥색"};
		boolean[] pwr = {true, true,false, true,false};
		
		for(int i = 0; i <tv.length; i++) {
			tv[i]= new Tv();
			tv[i].setChannel(chanl[i]);
			tv[i].setColor(clor[i]);
			tv[i].setPower(pwr[i]);	
			System.out.println("tv"+(i+1)+"객체의 채널은 " + tv[i].getChannel());
			System.out.println("tv"+(i+1)+"객체의 색은 " + tv[i].getColor());
			System.out.println("tv"+(i+1)+"객체의 파워는 " + tv[i].getPower());
		}	
	}
}
