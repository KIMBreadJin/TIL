package basic5;

public class Dropship extends Unit{

	@Override
	void move(int x, int y) {
		this.x=1000*x;
		this.y=1000*x;
		
	}
	//고유기능
	void load() {
		System.out.println("물건을 싣는 기능이 있어요");
	}
	void unload() {
		System.out.println("물건을 내리는 기능이 있어요");
	}

}
