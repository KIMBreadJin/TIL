package basic5;

import java.util.ArrayList;
import java.util.List;

public class UnitTest {

	public static void main(String[] args) {
		List<Unit> group = new ArrayList<Unit>();
		group.add (new Marine());
		group.add (new Tank());
		group.add (new Marine());
		group.add (new Dropship());
	
		for(Unit i : group) i.move(300,500);
		for(Unit i : group) System.out.println("x좌표 : "+ i.getX()+ ", y좌표 : "+i.getY());
		
		for(Unit i : group) {
			if(i instanceof Tank) {//어떤 instance 인지 확인 후 해당 instance로 다운 캐스팅
				Tank t = (Tank) i;
				t.changeMode();
			}
			
			else if(i instanceof Marine) {
				Marine m = (Marine) i;
				m.stimPack();
			}	
			else if(i instanceof Dropship) {
				Dropship d =(Dropship) i;
				d.unload();
				d.load();
				}
		
	
		
	}

}
}


