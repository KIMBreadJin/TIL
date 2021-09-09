package basic;

public class ArrayEx18_217p {

	public static void main(String[] args) {
		int[][] scores = {
				{100,100,100},{20,20,20},{30,30,30},{40,40,40}
		};
		int outerCnt =0, innerCnt=0;
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				System.out.printf("scores[%d][%d]=%d\n", i ,j, scores[i][j]);
			}
			outerCnt++;
			innerCnt = 0;
		}
		int sum =0;
		for(int[] score : scores) {
			for(int i : score) {
				sum+=1;
				
			}
		}
		System.out.println("총합은 " + sum);
	}

}
