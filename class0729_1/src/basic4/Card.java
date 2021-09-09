package basic4;

public class Card {
	static final int KIND_MAX=4; //카드 무늬의 수 
	static final int NUM_MAX = 13;// 무늬별 카드의 수 
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	private int kind;
	private int number;
	
	public int getKind() {return this.kind;}
	public int getNumber() {return this.number;}
	
	public void setKind(int kind) {this.kind=kind;}
	public void setNumber(int number) {this.number=number;}
	
	Card(){
		this(SPADE,1);
	}
	
	Card(int kind, int number){
		//System.out.println("카드 생성자 호출되어 카드 객체를 배열에 추가함 카드종류: " + kind + "카드번호 " +number);
		this.kind=kind;
		this.number=number;
	}
	@Override
	public String toString() {
		String[] kinds = {"","CLOVER","HEART","DIAMOND","SPADE"};
		String numbers= "0123456789XJQK"; //숫자 10을 X로 표현
		return "kind: " + kinds[this.kind] + " , number:  " +numbers.charAt(this.number);
				
	}
}
