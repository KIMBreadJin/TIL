package basic;

public class TireTest {

	public static void main(String[] args) {
		Tire[] tires = new Tire[10]; //random 값을 입력
		int[] manufac = new int[10]; // 1)한국타이어 2) 금호타이어 ,,,,
		String [] color = {"빨", "주", "노", "초", "파", "남", "보","검","흰","똥색","갈색"};
		String [] position = {"서울","경기","인천","부산","마산","대구","강북","강남","제주도","울릉도"};
		
		for(int i = 0; i<tires.length; i++) {
			tires[i] = new Tire();
		}
		
		for (int i = 0; i<manufac.length; i++) {
			manufac[i] = (i+1);
		}
		for(int i =0; i<tires.length; i++) {
			tires[i].setWeight((int)(Math.random()*100));
			tires[i].setColor(color[i]);
			tires[i].setPosition(position[i]);
			tires[i].setManufacturer(manufac[i]);
			tires[i].setFail(tires[i].isFail(tires[i].getWeight()));
		}
		for(int i =0; i<tires.length; i++) {
			System.out.println("타이거스펙/ 무게:" + tires[i].getWeight() +" 색:" + tires[i].getColor() +" 제조지역:" + tires[i].getPosition() + " 불량여부:" + tires[i].getFail() );
		
	}

}
}
