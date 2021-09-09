package basic;

import java.util.Scanner;

public class MultiArrEx4_227p {

	public static void main(String[] args) {
		String [][] words = { 
				{"chair","의자"}, {"computer","컴퓨터"},{"integer","정수"}, {"float","실수"}
		};
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<words.length;i++) {
			System.out.printf("문제%d, %s의 뜻은? " , i+1, words[i][0]);
			
			String temp = sc.nextLine();
			if(temp.equals(words[i][1])) {
				System.out.println("정답입니다. \n\n");
			}
			else {
				System.out.printf("틀렸습니다. 정답은 %s 입니다 \n\n", words[i][1]);
			}
		}
			}//end of main
	}//end of class
