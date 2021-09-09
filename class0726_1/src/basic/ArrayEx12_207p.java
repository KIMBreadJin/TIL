package basic;

public class ArrayEx12_207p {
	public static void main(String[] args) {
		String[] names = {"kim","park","yi"};
		for(int i = 0; i<names.length;i++) {
			System.out.println("names[" + i +"]=" + names[i]);
		}
		String tmp = names[2];//배열 names의 세번째 요소를 tmp에 저장
		System.out.println("tmp : "+tmp);
		names[0] = "Yu"; // 배열 names의 첫번째 요소를 "Yu"로 변경
		for(String i : names) System.out.println(i);
		
		String temp = "";
		
		temp = names[0];
		names[0] = names[2];
		names[2] = temp;
		
		System.out.println(names[0] +"  "+ names[2]);
		
		//문제 3) "kim" 과 Yi를 맞교환하는 로직을 구현하세요
	}

}
