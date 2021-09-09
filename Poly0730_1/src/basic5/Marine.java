package basic5;

public class Marine extends Unit{

	@Override
	void move(int x, int y) { //이동수단은 모두 가지고 있습니다. , 걸어서 , 날아서, 기어서 이동하나요?
		this.x=x;
		this.y=y;
		System.out.println("보병으로 이동해요");
	}
	@Override
	void stop() {
		System.out.println(" 지식인 Marine 클래스에서 멈춰요");
	}
	void stimPack() {//Marine 클래스의 고유 기능
		System.out.println("스팀팩 기능이 있어요");
	}

}
