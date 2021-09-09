package basic;

public class ArrayEx14_210p {
	}
	/*public static int length(String a) {
		int cnt=0;
		int i=0;
		char temp=' ';
		
			do {
				cnt++;
				temp = a.charAt(i++);
				cnt++;
			}
			while(temp !=' ');
			System.out.println(cnt);
			return cnt;
			}
		
	}*/
	
	public static void main(String[] args) {
		String str = "ABCDE";
		//int len = Length(len);
		str.toCharArray();
		Calculator a = new Calculator();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);//str의 i번째 문자를 ch에 저장
			System.out.println("str.charAt( " + i +" ) = " + ch);
			
		}
		//String을 ch[]로 변환
		char[] chArr  = str.toCharArray(str);
		System.out.println(chArr);
		for(char i :chArr) System.out.println(i);
	}

}
