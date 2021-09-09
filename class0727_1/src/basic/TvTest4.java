package basic;

public class TvTest4 {

	public static void main(String[] args) {
		Tv tv[] = new Tv[5];
	
		for(int i = 0; i <tv.length; i++) {
			tv[i]= new Tv();
		}
		
		int[] chanl ={10, 15, 30, 110, 1900};
		String[] clor ={"빨강", "노랑", "초록","보라","똥색"};
		boolean[] pwr = {true, true,false, true,false};
		
		for(int i = 0; i<tv.length; i++) {
			tv[i].setChannel(chanl[i]);
			tv[i].setColor(clor[i]);
			tv[i].setPower(pwr[i]);
			
		}
		
		for(int i=0; i<tv.length; i++) {
		System.out.println("tv"+(i+1)+"객체의 채널은 " + tv[i].getChannel());
		System.out.println("tv"+(i+1)+"객체의 색은 " + tv[i].getColor());
		System.out.println("tv"+(i+1)+"객체의 파워는 " + tv[i].getPower());
		

		
	}
	}
}
