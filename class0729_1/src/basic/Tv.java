package basic;

public class RadioTv extends TV{
	
	boolean volume;
	
	String volumeCheck(String a, boolean b) {
		String result = "";
		this.volume =b;
		if(this.volume) {
			for(int i=0; i<5; i++) {
				result  += a;
				
			}
			return result;
		}
	}

}
