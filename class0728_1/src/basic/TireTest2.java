package basic;

import java.util.ArrayList;
import java.util.List;

public class TireTest2 {

	public static void main(String[] args) {
		List<Tire> tires = new ArrayList<Tire>();
		//Tire[] tires = new Tire[10]; //random 값을 입력
		int[] manufac = new int[100]; // 1)한국타이어 2) 금호타이어 ,,,,
		String [] color = {"빨", "주", "노", "초", "파", "남", "보","검","흰","똥색"};
		String [] position = {"서울","경기","인천","부산","마산","대구","강북","강남","제주도","울릉도"};
		int Weight = 0;
		int j = 0;
		//for(int i = 0; i<tires.length; i++) {
			//tires[i] = new Tire();
		//}
		
		for (int i = 0; i<manufac.length; i++) {
			manufac[i] = (i+1);
		}
	
		for(int i =0; i<10; i++) {
			Weight = ((int)(Math.random()*100));	
			
		Tire a = new Tire();
		a.setWeight(Weight);
		a.setColor(color[i]);
		a.setPosition(position[i]);
		a.setManufacturer(manufac[i]);
		a.setFail(a.isFail(a.getWeight()));
		tires.add(a);
		}
		for(Tire i : tires) {
			System.out.println("타이거스펙/ 무게:" + i.getWeight() +" 색:" +i.getColor() +" 제조지역:" + i.getPosition() + " 불량여부:" + i.getFail() );
	
}
}
}
