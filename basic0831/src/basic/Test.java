package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		
		//문제 2)  main함수를 포함하는 클래스에서 
		List<Green> al = new ArrayList<>();
		Queue<Green> que = new LinkedList<>();
		Stack<Green> st = new Stack<>();
		boolean result =false;
		for (int i = 0; i < 5; i++) {
			Green a = new Green();
			a.setEng((int)(Math.random()*100));
			a.setMath((int)(Math.random()*100));
			a.setKorea((int)(Math.random()*100));
			a.setTotal((int)(Math.random()*100*3));
			al.add(a);
			result =al.get(i).greaterThan(a.getEng(), a.getKorea(),a.getMath() , a.getTotal());
			System.out.println(result);
		}
		
		//객체 5개씩 생성하여 멤버변수(데이터)를 채운 객체를 스택 리스트 큐에 추가하고 저장된 객체를 가져와서 
		// 객체의 메서드 호출시 국어 영어 수학 총점을 전달하고 반환되는 값 출력 
		for (int i = 0; i < 5; i++) {
			Green a = new Green();
			a.setEng((int)(Math.random()*100));
			a.setMath((int)(Math.random()*100));
			a.setKorea((int)(Math.random()*100));
			a.setTotal((int)(Math.random()*100*3));
			que.offer(a);
		}
		System.out.println("========================== 큐에 삽입한 결과 ");
//		que.forEach(i->{
//			System.out.println(i.greaterThan(i.getEng(), i.getMath(), i.getKorea(), i.getTotal()));
//		});
		//문제 1) for 문으로 que의 데이터를 이용하여 출력하세요 
		
		for (int i = 0; i < 5; i++) {
			Green a = new Green();
			a.setEng((int)(Math.random()*100));
			a.setMath((int)(Math.random()*100));
			a.setKorea((int)(Math.random()*100));
			a.setTotal((int)(Math.random()*100*3));
			st.push(a);
		}
		System.out.println("========================== 스택 에 삽입한 결과 ");
//		st.forEach(i->{
//			System.out.println(i.greaterThan(i.getEng(), i.getMath(), i.getKorea(), i.getTotal()));
//		});
		for (int i = 0; i < 5; i++) {
			Green a  = st.pop(); //마지막 데이터부터 하나씩 삭제하여 a에 저장 
			int korea = a.getKorea();
			int math = a.getMath();
			int eng = a.getEng();
			int total = a.getTotal();
			result = a.greaterThan(korea, math,eng,total);
			System.out.println(result);
			 
		}

	}

}
