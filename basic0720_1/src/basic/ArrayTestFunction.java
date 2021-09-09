package basic;

public class ArrayTestFunction {

	public static int arraySum(int a) {
		return a*2;
	}
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += arraySum(i);
			System.out.println(sum);
		}
		
	}

}
