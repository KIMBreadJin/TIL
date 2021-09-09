package basic;

public class CaptionTvTest {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.setChannel(10);
		ctv.channelDown();
		System.out.println(ctv.getChannel());
		ctv.displayCaption("1) 안녕하세요");
		ctv.setCation(true); 
		ctv.displayCaption("2) 안녕하세요");
		
		RadioTv rtv = new RadioTv();
		String uu = rtv.volumeCheck("홍길동",false);
		System.out.println(uu);
	}

}
