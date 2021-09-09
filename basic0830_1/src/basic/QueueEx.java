package basic;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx {
	static Queue q = new LinkedList<>(); // queue는 interface(부모) = linkedList(자식), 다형성(polymorphism)
	static final int MAX_SIZE =5;
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있어요");
		while(true) {
			System.out.println(">>");
			try {
				//화면으로 부터 라인단위로 입력 받는다
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();// 입력 받은것중 공백 제거
				if("".equals(input)) continue;// 입력 받은 문자열이 공백이면  while문으로 돌아감
				if(input.equalsIgnoreCase("q")) { // 대소문자 무시(ignore)
					System.out.println("프로그램을 종료헀습니다.");
					System.exit(0); // q로 입력되면 프르고르맹 종료
				}
				else if (input.equalsIgnoreCase("help")) {
					System.out.println(" help = 도움말을 보여줍니다");
					System.out.println(" q 또는 Q : 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어는 " + MAX_SIZE + "개 보여줍니다.");
				}
				else if (input.equalsIgnoreCase("history")){
					int i = 0;
					//입력받은 명령어를 저장
					save(input);
					//LinkedList의 내용을 보여준다
					LinkedList<String> tmp = (LinkedList<String>)q;
					ListIterator<String> it = tmp.listIterator(); //iterator(반복자 생성)
					while(it.hasNext()) { // 생성된 반복자를 이용하여 마지막 데이터 인지 확인 가능하고 마지막 데이터면 while문 종료
						 System.out.println(++i+" ," + it.next());//다음 데이터로 이동은 next()호출
					}
					//q.forEach(u->System.out.print(" " + u));
					//for(String a: q) System.out.print(a);
				}
				else {
					save(input);
					System.out.println(input);
				}
			}catch(Exception e) {
				System.out.println("입력 오류입니다.");
			}
		}
		
	}
	private static void save(String input) {
		//queue 에 저장
		if(!"".equals(input)) q.offer(input);//입력된 값이 공백이 아니면 큐에 저장
		//큐의 최대크기를 넘으면 제일 앞의 데이터 삭제
		if(q.size()>MAX_SIZE) q.remove();
	}

}
