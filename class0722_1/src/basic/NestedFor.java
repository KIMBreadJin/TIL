package basic;

public class NestedFor {

	public static void main(String[] args) {
		for(int i=2; i<=9; i++)	{
			System.out.println("===========");
			for(int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}

}
