package basic5;

public class TvTest {

		public static void main(String[] args) {
			//Furniture f = new Furnitur();
			
			String[] color = {"빨","주","노","초","파","남","보","검정","똥색","갈색"};
			boolean[] power = {true,false,true,false,true,false,true,false,true,false};
			Tv[]tvArr = new Tv[10];
			
			for(int i = 0; i<tvArr.length; i++) {
				tvArr[i].setChannel((int)(Math.random())*100);
				tvArr[i].setColor(color[i]);
				tvArr[i].setPower(power[i]);
				System.out.println(tvArr[i]);
			}
			
			}
		}

