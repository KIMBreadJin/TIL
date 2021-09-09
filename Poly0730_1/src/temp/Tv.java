package temp;

public class Tv {
	
	private String color; //색상
	private boolean power; // 전원상태 on/off
	private int channel;	//채널
	//문제 11 getter setter  만들기
	//문제 12 main함수에서 error 해결
	public Tv() {}
	
	public String getColor() {
		return this.color;
	}
	public boolean getPower() {
		return this.power;
	}
	public int getChannel() {
		return this.channel;
	}
	
	
	void setColor(String color) {
		this.color=color;
	}
	void setPower(boolean power) {
		this.power=power;
	}
	void setChannel(int channel) {
		this.channel=channel;
	}
	
	
	void power() {
		this.power =! power;
	}
	void channelUp() {
		this.channel++;
	}
	void channelDown() {
		this.channel--;
	}
	/*void color() {
		this.color=color;
	}*/
	
	public String green(int a) {
		String result=" ";
		if(a >= 70)
		{
			this.channel += 5;
			result="홍길동";
		}
		else {
			result="홍말자";
			this.channel-=3;
		}
		return result; }
			

	
	public int red(int a, int b) {
		
		int result = 1;
	{
		for(int i=0; i<b; i++) {
			result *= a;
		}
		if (result >= 200) 
			this.color = "빨강";
		return result;
		
	}
	}

	@Override
	public String toString() {
		return "Tv [color=" + color + ", power=" + power + ", channel=" + channel + "]";
	}
	
}
		
	//this 는 Tv클래스를 이용해서 생성된 객체의 주소를 가지고 있음
	//this를 이용하여 멤버변수에 접근함
