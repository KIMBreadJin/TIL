package basic2;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Robot {
	private String name;
	private MovingStrategy movingStrategy;
	private AttackStrategy attackStrategy;
	
	public Robot(String name) {
		this.name=name;
		
	}
	public void move() {
		movingStrategy.move();
	}
	public void attack() {
		attackStrategy.attack();
	}
	 
}
