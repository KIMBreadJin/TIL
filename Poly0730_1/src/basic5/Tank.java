package basic5;

public class Tank extends Unit{

	@Override
	void move(int x, int y) {
		this.x=100*x;
		this.y=100*y;
		System.out.println("탱크로 이동해요");
		
	}
	//고유기능
	void changeMode() {
		System.out.println("공격 모드를 변환 시키는 기능이 있어요");
	}
}
