package basic;

import java.util.Scanner;

public class UnderstandTest2 {

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
		System.out.println("홍길동은 영어로?");
		
		String a = sc.nextLine();
		if(a.equals(t[0][1])) {
			System.out.println("정답이에요");
			cnt++;
		}
		
		else System.out.println("오답이에요");
		
		System.out.println("홍말자은 영어로?");
		a = sc.nextLine();
		if(a.equals(t[1][1])) {
			System.out.println("정답이에요");
			cnt++;
		}
		else System.out.println("오답이에요");
		
		System.out.println("김개똥은 영어로?");
		a = sc.nextLine();
		if(a.equals(t[2][1])) {
			System.out.println("정답이에요");
			cnt++;
		}
		else System.out.println("오답이에요");
		
		System.out.println("그린은 영어로?");
		a = sc.nextLine();
		if(a.equals(t[3][1])) {
			System.out.println("정답이에요");
			cnt++;
		}
		else System.out.println("오답이에요");
		
		System.out.println("빨강은 영어로?");
		a = sc.nextLine();
		if(a.equals(t[4][1])) {
			System.out.println("정답이에요");
			cnt++;}
		else System.out.println("오답이에요");
		
		System.out.printf("%d개 맞추셨습니다",cnt);
  			}//end of main
	}//end of class
