package basic2;

public class FlyingStrategy implements MovingStrategy {

	@Override
	public void move() {
		System.out.println("나는 날수가 있어요");
	}

}
