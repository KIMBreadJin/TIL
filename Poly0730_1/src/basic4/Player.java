package basic4;

public abstract class Player {
	abstract void play(int pos); // 함수의 구현부가 없다, 추상화(abstract), 함수의 정의
	void running() { 
		System.out.println("달리고 있어요");
	}
}
