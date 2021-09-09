package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrkTert {
	//static int tot =0; //함수 밖의 멤버변수 객체생성이 필요 없는 멤버변수
	public static void main(String[] args) {
		//문제 4) main함수를 포함하는 클래스에서 객체 생성
		Truck a = new Truck();
		//setter를 이용하여 멤버변수의 값을 저장하고 
		a.setJungja(false);
		a.setMikum(34.7f);
		List<Integer> al =  new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			al.add((i+1) *4+3);
		}
		a.setNumber(al);
		a.setPunk(78);
		a.setTire(54);
		//getter를 이용하여 저장된 멤버변수의 값을 출력
		System.out.println("정자 : " + a.getJungja());
		System.out.println("미금: " +a.getMikum());
		System.out.println("펑크 : " + a.getPunk());
		a.getNumber().forEach(i-> System.out.println("번호 : "+ i));//람다(arrow function ) 
		System.out.println("타이어 : " +a.getTire());
		//문제 5) 
		Map<String, Truck> map = new HashMap<>();
		Truck truck1 = new Truck();
		truck1.setJungja(false);
		truck1.setMikum(34.8f);
		al.add(90);
		al.add(70);
		al.add(80);
		truck1.setNumber(al);
		truck1.setPunk(23);
		truck1.setTire(98);
		map.put("보라", truck1);
		
		Truck truck2 = new Truck();
		truck2.setJungja(true);
		truck2.setMikum(34.7f);
		al.add(91);
		al.add(71);
		al.add(81);
		truck2.setNumber(al);
		truck2.setPunk(28);
		truck2.setTire(198);
		map.put("주황", truck2);
		
		Truck truck3 = new Truck();
		truck3.setJungja(true);
		truck3.setMikum(32.7f);
		List<Integer> al2 = new ArrayList<Integer>();
		al.forEach(i-> al2.add(i*3)); //al에서 하나씩 꺼내서 3배한 것을 al2에 저장하고 그것을 전달함 
		truck3.setNumber(al2);
		truck3.setPunk(128);
		truck3.setTire(108);
		map.put("흰색", truck3);
		
		Truck truck4 = new Truck();
		truck4.setJungja(true);
		truck4.setMikum(32.7f);
		List<Integer> al3 = new ArrayList<Integer>();
		al.forEach(i-> al3.add(i*5 +2)); //al에서 하나씩 꺼내서 3배한 것을 al2에 저장하고 그것을 전달함 
		truck4.setNumber(al3);
		truck4.setPunk(281);
		truck4.setTire(68);
		map.put("검정", truck4);
		
		Truck truck5 = new Truck();
		truck5.setJungja(true);
		truck5.setMikum(32.7f);
		List<Integer> al4 = new ArrayList<Integer>();
		al.forEach(i-> al4.add(i*7 +9)); //al에서 하나씩 꺼내서 3배한 것을 al2에 저장하고 그것을 전달함 
		truck5.setNumber(al3);
		truck5.setPunk(11);
		truck5.setTire(22);
		map.put("녹색", truck5);
		//map에 put을 이용하여 Truck객체를 5개 저장함 
		// key값은 = "보라","주황","흰색","검정","녹색"
		// 5개의 객체를 map의 key에 value값으로 저장하고 
		// 그 객체의 멤버변수에 setter를 이용하여 값을저장하고 
		
		//map에서 get을 이용하여 값을 출력 하세요 
		System.out.println("정자 :" + map.get("보라").getJungja());
		System.out.println("미금 : " + map.get("보라").getMikum());
		map.get("보라").getNumber().forEach(i-> System.out.println("map ( 보라: ) 번호: " +i));
		System.out.println("타이어 : " +map.get("보라").getTire());
		System.out.println("펑크  : " +map.get("보라").getPunk());
		
		System.out.println("정자 :" + map.get("주황").getJungja());
		System.out.println("미금 : " + map.get("주황").getMikum());
		map.get("주황").getNumber().forEach(i-> System.out.println("map ( 주황: ) 번호: " +i));
		System.out.println("타이어 : " +map.get("주황").getTire());
		System.out.println("펑크  : " +map.get("주황").getPunk());
		
		System.out.println("정자 :" + map.get("흰색").getJungja());
		System.out.println("미금 : " + map.get("흰색").getMikum());
		map.get("흰색").getNumber().forEach(i-> System.out.println("map ( 흰색: ) 번호: " +i));
		System.out.println("타이어 : " +map.get("흰색").getTire());
		System.out.println("펑크  : " +map.get("흰색").getPunk());
		
		System.out.println("정자 :" + map.get("검정").getJungja());
		System.out.println("미금 : " + map.get("검정").getMikum());
		map.get("검정").getNumber().forEach(i-> System.out.println("map ( 검정: ) 번호: " +i));
		System.out.println("타이어 : " +map.get("검정").getTire());
		System.out.println("펑크  : " +map.get("검정").getPunk());
		
		System.out.println("정자 :" + map.get("녹색").getJungja());
		System.out.println("미금 : " + map.get("녹색").getMikum());
		map.get("녹색").getNumber().forEach(i-> System.out.println("map ( 녹색: ) 번호: " +i));
		System.out.println("타이어 : " +map.get("녹색").getTire());
		System.out.println("펑크  : " +map.get("녹색").getPunk());
		
		List<Integer> al7 = new ArrayList<>();
		List<Integer> al8 = new ArrayList<>();
		List<Integer> al9 = new ArrayList<>();
		List<String> al10 =new ArrayList<>();
		for (int j = 0; j < 100; j++) {
			al7.add(j+1); //1~100까지 숫자
		}
		al7.forEach(i-> al8.add(i*3));
		al8.forEach(i-> {
			if(i%2==0) al9.add(i);
		});
		al9.forEach(i->System.out.println(i));
		al8.forEach(i-> al10.add(i+"홍길동"));
		al10.forEach(i->System.out.println(i));		
		List<Truck> trucks = new ArrayList<>();
		trucks.add(map.get("검정"));
		trucks.add(map.get("녹색"));
		trucks.add(map.get("흰색"));
		trucks.add(map.get("주황"));
		trucks.add(map.get("보라"));
		List<Integer> temp = new ArrayList<>();
		trucks.forEach(i-> System.out.println("타이어 :" + i.getTire()));
		trucks.forEach(i-> System.out.println("펑크 :" + i.getPunk()));
		trucks.forEach(i->i.getNumber().forEach(j->{
			temp.add(j*3+5);
			System.out.println(j);
		}));
		temp.forEach(i->System.out.println(i));
		for(Truck i : trucks) System.out.println(i.getMikum());
		List<Float> green = new ArrayList<>();
		
		trucks.forEach(i->{
			float u = i.getMikum() *2;
			if(u>66) green.add(u);
		});
		green.forEach(i-> System.out.println("그린 값 : " + i));
		
		List<Integer> numbers = new ArrayList<>();
		trucks.forEach(i -> {
			int tot = 0;
			for(int q : i.getNumber()) {
				tot+=q;
		}		
			System.out.println("총전 " + tot);
			numbers.add(tot);
		});
		numbers.forEach(i->System.out.println("numbers 총점 : "+ i));

}
}
