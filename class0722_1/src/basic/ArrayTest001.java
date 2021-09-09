package basic;

public class ArrayTest001 {
	
	public static int sub(int[] a) {
		int sum =0;
		for (int i=0; i<a.length; i++)
			sum += a[i];	
			System.out.println(sum);
		return sum;
	}
	public static boolean isFinal (String a) {
			System.out.println(a.length());
			if (a.length()%2==0) {
				return true;
			}
			else
				return false;
	}
	public static void main(String[] args) {
		
		int[] arr = new int [20];
		for(int i=0; i<arr.length; i++) {
			arr[i] =(int)(Math.random()*50);
			
		}
		sub(arr);
		
		boolean result = isFinal("홀말자 입니다.");	
		if (result = true)
			{
			System.out.println("짝수일때" +sub(arr) * 2);		
			}
		else if(result = false)
			System.out.println("홀수일때 " +sub(arr) * 3);
			
		}
}