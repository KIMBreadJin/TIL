package class222;

import java.util.ArrayList;
import java.util.List;

import basic5.Tv;

public class TvTest {
	public static void main(String[] args) {
		Furniture f = new Furniture();
		String[] color = {"빨","주","노","초","파","남","보","검정","똥색","갈색"};
		boolean[] power = {true,false,true,false,true,false,true,false,true,false};
		List<Tv> tvArr = new ArrayList<Tv>();
		
		for(int i = 0; i<10; i++) {
			Tv a = new Tv();
			a.setchannel((int)(Math.random()*20));
			a.setPower(power[i]);
			a.setColor(color[i]);
			tvArr.add(a);
			
		}
		f.setTvs(tvArr);
		f.setName("가구점");
		
		Tv a = f.pick();
		System.out.println(a);
		int ind = (int)(Math.random()*10);
		a = f.pick(ind);
		System.out.println("Tv 객체 배열의 "+ ind + "번쨰 객체는 "+a);
		
		}
	}
