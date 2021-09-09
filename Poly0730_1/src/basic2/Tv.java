package basic2;

public class Tv extends Product{

	Tv() {  //implicit(암시적)  <=> explicit(명시적)    constructor(생성자)
		//부모 클래스의 생성자 Product(int price)호출
		super(100); //Tv 가격을 100만원으로 한다	
	}
	
	@Override
	public String toString() { // 가장 최고의 조상인 Object 클래스의 toString 매서드를 재정의(override)
		
		return "텔레비전";
	
	

}
}
