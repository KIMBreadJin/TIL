package basic3;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Bus bus = new Bus();
		List<Integer> Jj = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			Jj.add(3*i);
		}
		
		List<Car> cars  = new ArrayList<>();
		Car[] carsArr= new Car[15];
		for (int i = 0; i < carsArr.length; i++) {
			Car a = new Car();
			a.setGreen(5+i);
			a.setName("홍길동");
			a.setTire(10+i);
			a.setWindow(15+i);
			carsArr[i]= a;
			cars.add(a);
		}
		
		List<Bus> buses = new ArrayList<>();
		Bus[] busArr= new Bus[5];
		for (int i = 0; i < busArr.length; i++) {
			Bus a = new Bus();
			a.setDaegu(4+i);
			a.setJeju(Jj);
			a.setJunju(cars);
			a.setPohang(8.8f+i);
			a.setSeoul(12+i);
			buses.add(a);
		}
	List<String> StSum = new ArrayList<>();
		buses.forEach(i->{
			System.out.println("대구 "+i.getDaegu());
			System.out.println("서울 "+i.getSeoul());
			System.out.println("포항 "+i.getPohang());
			i.getJeju().forEach(j -> System.out.println("제주 정수형 리스트:" + j));
			i.getJunju().forEach(j->{
				System.out.println("제주 카 리스트 : 창문 " + j.getWindow());
				System.out.println("제주 카 리스트 : 타이어 " + j.getTire());
				System.out.println("제주 카 리스트 : 이름 " + j.getName());
				System.out.println("제주 카 리스트 : 녹색 " + j.getGreen());
				System.out.println("문자열 결합" + j.getWindow() + j.getTire() + j.getName()  + j.getGreen());
			});
		});
	List<String> str = new ArrayList<>();
		int cnt = 0;
		int busCnt=0;
		int carCnt =0;
		for(Bus u : buses) {
			for(Car j:u.getJunju()) {
				str.add(j.getWindow() +j.getTire() + j.getName() + j.getGreen());
				cnt++;
				carCnt++;
			}
			System.out.println("차 반복 회수 " + carCnt );
			busCnt++;
		}
		str.forEach(i-> System.out.println(i));
		System.out.println("반복 회수는 " +cnt + "버스 반복 회수 " +busCnt);		
	}
}


