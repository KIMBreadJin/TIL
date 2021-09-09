package basic;

public class Array01Test3 {

	public static void main(String[] args) {
		int num=6;
		if(num==1) {
			System.out.println("SK");
		}
		else if(num==6) {
			System.out.println("KTF");
		}
		
		else if(num==9) {
			System.out.println("LG");
		}
		
		else {
			System.out.println("UNKNOWN");
		}
		System.out.println("===================");
		switch(num){
			case 1:
				System.out.println("SK");
				break;
			case 6:
				System.out.println("KTF");
				break;
			case 9:
				System.out.println("LG");
				break;
			default:
				break;
				
		}
		
	}

}
