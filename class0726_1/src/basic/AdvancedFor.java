package basic;

public class AdvancedFor {

	public static void main(String[] args) {

	
		String[][] str = { {"홍길동","홍말자","김개똥","홍개똥","홀똥개"},
						{"홍길동1","홍말자","김개똥","홍개똥","홀똥개"},
						{"홍길동12","홍말자12","김개똥12","홍개똥12","홀똥개221"},
						{"홍길동13","홍말자13","김개똥13","홍개똥13","홀똥개13"}
		};
		
		for(int i = 0; i<str.length; i++) {
			for(int j =0; j<4; j++) {
				System.out.println(str[i][j]);
			}
		}
		
		for(String[] t:str) {
			for(String u:t) {
				System.out.println(u);
			}
		}
				
}
}

