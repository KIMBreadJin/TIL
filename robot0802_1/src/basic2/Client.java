package basic2;


public class Client {

	public static void main(String[] args) {
		Robot taekwonV = new TaekwonV("태권브이");
		Robot atom = new Atom("아톰");
		
		taekwonV.setMovingStrategy(new WalkingStrategy()); //이동 전략 설정 :걷기
		taekwonV.setAttackStrategy(new MissileStrategy());// 공격 전략 성정: 미사일
		
		atom.setMovingStrategy(new FlyingStrategy());
		atom.setAttackStrategy(new PunchStrategy());
		atom.setMovingStrategy(new RunningStrategy());
		System.out.println("내이름은 " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println("내이름은 " + atom.getName());
		atom.move();
		atom.attack();
		

	}

}
