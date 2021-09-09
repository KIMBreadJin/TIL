package basic;

import java.util.Scanner;

public class MultiArrEx2_223p {

	public static void main(String[] args) {
		final int SIZE = 5;  //final 은 수정 불가인 상수형
		int x=0, y=0, num=0;
		int [][] bingo = new int[SIZE][SIZE];
		Scanner sc = new Scanner(System.in);
		
		//배열의 모든 요소를 1부터 SIZE*SIZE 까지의 숫자로 초기와
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				bingo[i][j] = i*SIZE+j+1;
			}
		}
		
		//배열에 저장된 값을 섞는다(shuffle)
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				x=(int)(Math.random()*SIZE);
				y=(int)(Math.random()*SIZE);
				//bingo[i][j]의 입의로 선택된 값 bingo[x][y]를 바꾼다
				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][j];
				bingo[x][y] = tmp;
			}
		}
		do {
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					System.out.printf("%2d " , bingo[i][j]);
				}
				System.out.println();
			}
		
		System.out.println();
		System.out.printf("1~%d 의 숫자를 입력하세요 (종료 : 0)> ",SIZE*SIZE);
		String tmp =sc.nextLine(); //키보드로 입력받은 값을 tmp에 저장
		num = Integer.parseInt(tmp);//정수로 변환
		
		//입력 받은 숫자와 같은숫자가 저장된 요소를 찾아서 0을 저장
		outer:
			for(int i= 0; i<SIZE;i++) {
				for(int j =0; j<SIZE; j++) {
					if(bingo[i][j] == num) {
						bingo[i][j] = 0;
						break outer;// 2중 반복문 중단
					}
				}
			}
		}while(num!=0);
	}//main 끝
}//클래스 끝
