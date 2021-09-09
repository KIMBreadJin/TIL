package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Father a= new Father();
		a.setChild(false);
		a.setDaughter(12.9f);
		List<Integer> al = new ArrayList<>();
		for (int i = 0; i< 23; i++) {
			al.add((i+7)*3);
		}
		a.setGoods(al);
		a.setMotehr(15);
		List<Integer> a12 = new ArrayList<>();
		al.forEach(i -> {
			if(i%2 ==0) a12.add(i*6);
		});
		a.setProduct(a12);
		a.setSon(20);
		System.out.println("아이 : " + a.getChild());
		System.out.println("엄마 : " + a.getMotehr());
		System.out.println("딸 : " + a.getDaughter());
		al.forEach(i->System.out.println("상품 : " + i));
		al.forEach(i-> System.out.println("제품 : " + i));
		System.out.println("제품 데이터 개수 : " + a.getGoods().size() );
		System.out.println("상품 데이터 개수 : " + a.getProduct().size());
		System.out.println("아들 : " + a.getSon());
		Map<Integer,Father> fathers = new HashMap<>();
		
		Father father1 = new Father();
		Father father2 = new Father();
		Father father3 = new Father();
		Father father4 = new Father();
		Father father5 = new Father();
		Father[] fatArr = {father1,father2,father3,father4,father5};
		boolean flag = true;
		for(int i = 0; i< fatArr.length; i++)
		{
			if(i*3 == 0) flag = false;
			fatArr[i].setChild(flag);
			fatArr[i].setDaughter(i*12.6f);
			List<Integer> a13 = new ArrayList<>();
			a12.forEach(j -> {
				a13.add(j+7);
			});
			fatArr[i].setGoods(a13);
			fatArr[i].setMotehr(i+6+i*100);
			fatArr[i].setSon(i+20+i*i);
			List<Integer> a14 = new ArrayList<>();
			a12.forEach(j -> {
				a14.add(j+12);
			});
			System.out.println("메서드 호출 전 리스트의 크기는 "  +fatArr[i].getGoods().size());
			int tt =fatArr[i].insert(5+i);
			System.out.println("메서드 호출 후 리스트의 크기는 "  +fatArr[i].getGoods().size());
			System.out.println("메서드 호출 후 반환되는 값 정수 " + tt);
			boolean qq = fatArr[i].pretty(7+i);
			System.out.println("메서드 호출 후 반환되는 값 논리 " + qq);
		}
		for(int i = 0; i< 5; i++) {
			fathers.put(i+1, fatArr[i]);
		}
		for(int i = 1; i< 6; i++) {
		System.out.println(i + "번 객체의 아이는 : " + fathers.get(i).getChild());
		System.out.println(i + "번 객체의 엄마는 : " + fathers.get(i).getMotehr());
		System.out.println(i + "번 객체의 아들는 : " + fathers.get(i).getSon());
		System.out.println(i + "번 객체의 딸는 : " + fathers.get(i).getDaughter());
		fathers.get(i).getGoods().forEach(j->System.out.println("상품은 " + j));
		fathers.get(i).getProduct().forEach(j->System.out.println("제품은 " + j));
		}
		List<Integer> res = new ArrayList<>();
		List<List<Integer>> resArr = new ArrayList<>();
		for(int i = 1; i<6; i++) {
			int sum = 0;
			for(int j : fathers.get(i).getGoods()) {
				sum+=j;
				res.add(j); //원래 데이터를 새로운 list에 추가하고
			}
			res.add(sum); // 각각의 list의 마지막에 총점을 추가함
			resArr.add(res);
			res.forEach(q->System.out.println("총합을 더한 리스트 " + q));
			System.out.println(sum);
			res = new ArrayList<>();
		}
		resArr.forEach(i->{
			i.forEach(j->{
				System.out.println(j);
			});
				System.out.println("================" + i.get(i.size()-1));
				//마지막 데이터를 출력하고자
				//list의 크기를 구하는 메서드는 size이고 0부터 시작하므로 -1을 하면 마지막 인덱스이고
				//list에서 data를 가져오려면 get(index)하면 되므로 마지막 데이터를 추출 가능함
		});
	}

}
