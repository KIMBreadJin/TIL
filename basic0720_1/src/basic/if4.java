package basic;

public class if4 {

	public static void main(String[] args) {
		int[] korea = new int[100];
		int[] math = new int[100];
		int[] eng = new int[100];
		int cntElse =0;
		int cntIf=0;
		for(int i = 0; i<100; i++) {
			korea[i] = (int)(Math.random()*100)+1;
			math[i] = (int)(Math.random()*100)+1;
			eng[i] = (int)(Math.random()*100)+1;
		}
		
		for(int i = 0; i<100; i++) {
			if(korea[i]>90 && math[i]>=40 && eng[i]>20) System.out.println("");
			else {
				cntElse++;
				System.out.println("불합격" + cntElse);
			}
			
			if(korea[i]<=90 || math[i] <40 || eng[i] <=20) {
				cntIf++;
				System.out.println("else와 동일해 보입니다." + cntIf);
			}
		}
}
}
