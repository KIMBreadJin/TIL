package basic;

import java.util.Scanner;

public class UnderstandTest {

	public static void main(String[] args) {
		String [][] t = {
				{"홍길동","hong"},
				{"홍말자", "mal"},
				{"김개똥", "kim"},
				{"그린","green"},
				{"빨강","red"}
		
		};
		int cnt = 0;	
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<t.length; i++) {
			System.out.println(t[i][0] + "은 영어로?");
			String a = sc.nextLine();
			if(a.equals(t[i][1])) {
				System.out.println("정답이에요");
				cnt++;
			}
			else System.out.println("오답이에요");
		}

		
		System.out.printf("%d개 맞추셨습니다",cnt);
  			}//end of main
	}//end of class
