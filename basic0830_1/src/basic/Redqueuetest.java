package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Redqueuetest {
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼수 있어요");
		List<String> al = new ArrayList<>();
		Redqueue rq = new Redqueue(); 
		Queue<String> que = new LinkedList<>();	
		
		while(true) {
			System.out.println(">>");
			try {	 
				Scanner sc = new Scanner(System.in); 
				String input = sc.nextLine().trim();
				if("".equals(input)) continue;
				if (input.equalsIgnoreCase("history")){
					for(String u:rq.getData()) {
						que.offer(u);
					}
				}
				else if (input.equalsIgnoreCase("x")) {
					for(String u:que) System.out.println(u);
				}
				else if(input.equalsIgnoreCase("q")) {
					break;
				}
				else {
					al.add(input);	
					rq.setData(al);
					System.out.println(input);
				}
			}catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		} //while의 끝
		System.out.println("프로그램을 종료했습니다. ");
	}//main의 끝
	
}
