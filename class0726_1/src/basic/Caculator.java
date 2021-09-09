package basic;

public class Caculator {
	public static char[] toCharArray(String a) {
		char [] result = new char[10];
		for(int i=0; i< a.length(); i++) {
			result[i]= a.charAt(i);
		}
		return result;
}
	public int getSum(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i]%2==0) {
				sum+=a[i];
			}
		}
		return sum;
	}
	public void exchange(int[] numArr) {
		int empty=0;
		int j=0;
		for(int i=0;i<6; i++) {
			j=(int)(Math.random()*45);
			
		}
	}
	}
