package basic;

import java.io.File;

public class tryTest {

	public static void main(String[] args) {
		int[] a = new int[5];
		//파일 입출력 또는 데이터 베이스 접근시는 무조건 try ~ catch로 감싸라
		File p = new File("c:/1.txt");
		try {
			a[0] = 10;
			System.out.println(a[0]);
			a[1] = 20;
			System.out.println(a[1]);
			a[2] = 30;
			System.out.println(a[2]);
			a[3] = 40;
			System.out.println(a[3]);
			a[4] = 50;
			System.out.println(a[4]);
			a[5] = 60;
			System.out.println(a[5]);
			a[6] = 70;
			System.out.println(a[6]);
			// p 파일 오픈
			
		}catch(Exception e) {
			System.out.println("예외가 발생하면 무조건 여기로 들어와요");
			
		}finally { // Exception 발생하던 정상이던 무조건 여기 구문을 실핼하라
			
		}
	}

}
