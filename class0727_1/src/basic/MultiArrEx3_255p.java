package basic;

public class MultiArrEx3_255p {

	public static void main(String[] args) {
		int [][] m1 = {
				{1,2,3},{4,5,6}
		};
		
		int [][] m2 = {
				{1,2},{3,4},{5,6}
		};
		final int ROW = m1.length;
		final int COLUMN = m2[0].length;
		final int M2_ROW = m2.length;
		int[][] m3 = new int[ROW][COLUMN];
		
		for(int i =0;i<ROW;i++) {
			for(int j =0;j<COLUMN;j++) {
				for(int k =0;k<M2_ROW;k++) {
				m3[i][j] += m1[i][k] * m2[k][j];
			}
		}
		}
		// 행렬 m3 출력
			for(int[] i : m3) {
				for(int j : i) {
					System.out.printf("%3d ", j);
					
				}
			}
			System.out.println();
		}//end of main
	}//end of class
