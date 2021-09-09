package basic;

import java.util.Scanner;

public class TvTest {

	public static void main(String[] args) {
		Tv tv;
		tv=new Tv();
		tv.setChannel(7);
		tv.channelDown();
		tv.channelDown();
		tv.channelDown();
		System.out.println("현재 채널 :"+ tv.getChannel());
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		
		Tv tv1 = new Tv();
		tv.setColor("빨강");
		System.out.println(tv.getColor());
		Scanner sc = new Scanner(System.in);
		System.out.println("1) green 2) red 3) 채널 100개 증가 4)");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("현재 채널 : "+ tv.getChannel());
			String res = tv.green(70);
			System.out.println(res);
			System.out.println("green에서 호출 1)" + tv.getChannel());
			String temp = tv.green(80); 
			System.out.println(temp);
			System.out.println("70보다 큰 수를 파라미터로 전달 green 메서드 호출 후 적용된 채널은 2)원래 채널의 값에 5증가" +tv.getChannel());
			temp = tv.green(40);
			System.out.println(temp);
			System.out.println("70보다 작은 수를 전달 green 메서드 호출 후 채널 3) 원래 값에서 3 감소" + tv.getChannel());
			break;
			
		case 2:
			System.out.println("첫번째 숫자 입력하세요 ");
			int first = sc.nextInt();
			System.out.println("두번째 숫자 입력하세요");
			int second = sc.nextInt();
			int res22 = tv.red(first, second);
			System.out.println(res22);
			System.out.println(tv.getColor());
			break;
		case 3:
			for(int i = 0; i<100; i++) {
				tv.channelUp();
			}
			System.out.println(tv.getChannel());
			break;
		case 4:
			boolean gon = tv.getPower();
			if (gon = true) {
				System.out.println(tv.getColor());
			}
			else {
				System.out.println(tv.getChannel());
				break;
			}
			}
		
		}

	}

