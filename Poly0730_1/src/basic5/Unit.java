package basic5;

public abstract class Unit {
	protected int x,y;
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	abstract void move(int x, int y);//추상메서드, 상속받아서 구현부를 강제로 구현해야 함
	void stop() {
		System.out.println("현재 위치에서 멈춤 x: " + this.x + "y: " +this.y);
	}
}
