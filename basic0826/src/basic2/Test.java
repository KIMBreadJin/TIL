package basic2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// 문제 4) main함수를 포함하는 클래스에 객체 생성후 setter ,getter를 호출하여 값을 저장후 출력함
		Bus bus = new Bus();
		bus.setDaegu(400);
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			li.add((int)(Math.random()*25)+3);
		}
		bus.setJeju(li);
		List<Car> cars  = new ArrayList<>();
		Car[] carsArr= new Car[30];
		for (int i = 0; i < carsArr.length; i++) {
			Car a = new Car();
			a.setGreen((int)(Math.random()*23)+2);
			a.setName("홍개똥 "+  (int)(Math.random()*100)+9);
			a.setTire((int)(Math.random()*23)+12);
			a.setWindow((int)(Math.random()*23)+22);
			carsArr[i]= a;
		}
		for(Car i:carsArr) cars.add(i);
		// jeju에는 random으로 데이터 20개  저장하고 junju에는 30개의  Car객체를 생성하여 데이터(멤버변수)를
		//전달하여 호출함 
		bus.setJunju(cars);
		bus.setPohang(34.6f);
		bus.setSeoul(20);
		
		System.out.println("포항 : " + bus.getPohang());
		System.out.println("서울 : " +bus.getSeoul());
		System.out.println("대구 "  + bus.getDaegu());
		bus.getJeju().forEach(i-> System.out.println("제주리스트 정수 : " + i));
		bus.getJunju().forEach(i->{//하나씩 꺼내온 데이터가 무엇인가? 만약 객체라하면  getter를 통해 데이터 조회가능 
			System.out.println("전주 카 리스트 객체 :  타이어 " + i.getTire()+  "창문: " + i.getWindow());
			System.out.println("전주 카 리스트 객체 :  이름 " + i.getName()+  "녹색 : " + i.getGreen());
		});
		// 문제 5) 
		Map<String,Bus> map = new HashMap<>();
		List<Bus> buses  = new ArrayList<>();
		Bus[] busArr= new Bus[5];
		for (int i = 0; i < busArr.length; i++) {
			Bus a = new Bus();
			a.setDaegu((int)(Math.random()*15)+7);
			a.setJeju(li);
			a.setJunju(cars);
			a.setPohang((float) (Math.random()*15));
			a.setSeoul((int)(Math.random()*15)+7);
			busArr[i] =a;
		}
		for (int i = 0; i < busArr.length; i++) {
			map.put("홍"+(i+1), busArr[i]);
		}
		int total =0;
		int jejuTotal=0;
		int junjuTotal=0;
		List<Car> carList = new ArrayList<>(); 
		List<Integer> jejuTemp=new ArrayList<>();
		List<Integer> jejuTotalList = new ArrayList<>();
		List<Integer> junjuTotalList = new ArrayList<>();
		
		for (int i = 0; i < busArr.length; i++) {
			System.out.print("대구: "+ map.get("홍"+(i+1)).getDaegu() + " ");
			System.out.print(" 포항: "+ map.get("홍"+(i+1)).getPohang()+ " ");
			System.out.print(" 서울: "+ map.get("홍"+(i+1)).getSeoul()+ " ");
			map.get("홍"+(i+1)).getJeju().forEach(j->System.out.print("제주리스트 " + j +" "));
			map.get("홍"+(i+1)).getJunju().forEach(j->{
				System.out.println("카 리스트 : 타이어  "+ j.getTire());
				System.out.println("카 리스트 : 창문  "+ j.getWindow());
				System.out.println("카 리스트 : 이름  "+ j.getName());
				System.out.println("카 리스트 : 녹색   "+ j.getGreen());
			});
			total = map.get("홍"+(i+1)).wireframe(carsArr[i]);
			System.out.println("반환된 총합은 : " + total);
				
			System.out.println("\n=================");
			jejuTemp = map.get("홍"+(i+1)).getJeju();
			for(int q:jejuTemp) jejuTotal+= q;
			System.out.println("제주 총합은 : " +jejuTotal);
			jejuTotalList.add(jejuTotal);
			
			carList = map.get("홍"+(i+1)).getJunju();
			for(Car car:carList) junjuTotal+= car.getGreen() + car.getTire() + car.getWindow();
			System.out.println("전주 총합은 : " +junjuTotal);
			junjuTotalList.add(junjuTotal);
		}
		
		jejuTotalList.forEach(i->System.out.print("제주총합 리스트 " + i +" "));
		System.out.println("\n");
		junjuTotalList.forEach(i->System.out.print("전주총합 리스트 " + i +" "));
		
			//문제 1) jejuTotal 값이 5개 출력되므로  배열 또는 List를 활용하여
			//저장후 이 반복문 밖에서 출력하세요 
			// 태수 혜원 
			//문제 2) getJunju를 Car 객체 를 배열(ArrayList) 로 받아 tire, green,window의 총합출력 
			// 5번 반복 되므로 여기서 출력하면 5개 잘 출력이 됩니다
			// 배열 또는 List를 활용하여
				//저장후 이 반복문 밖에서 출력하세요 
			//권태수 
			
		
		//위의 코드 보지 말고 직접 입력해서 채워주세요 
		// key= ("홍1" ,"홍2","홍3","홍4","홍5") value= Bus객체들
		// wireframe 메서드 호출 후반환 된 값 출력
		

	}

};
