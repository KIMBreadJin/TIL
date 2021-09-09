package basic;

public class Test0802 {
public static void main(String[] args) {
	int[] Three = new int[10];
	int sum = 0;
	for(int i = 0; i<Three.length; i++) {
		Three[i] = (i+1)*3;
		if(Three[i] % 2 == 0) {
			sum += Three[i];
			
		}
	
	}
	System.out.println("열개의 3의 배수중 짝수인 것의 합 =" + sum);
}	
}
