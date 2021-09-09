package basic;

public class ArrayEx5_196p {

	public static float getAvg(int[]score, int[] score7, int t) {
		int sum = 0;
		float average  = 0f;
		int[] newArr = new int[score.length];
		
		if(t%2==0) {
			for(int i=0; i<score.length; i++) {
				newArr[i] = score[i]*2 +score7[i];
			}
		}
		else {
			for(int i=0; i<score.length;i++) {
				newArr[i] = score[i] + score7[i]*3;
			}
		}
		for(int i=0;i<score.length;i++) newArr[i] = score[i] +score7[i];
		for(int i=0;i<score.length;i++) sum += newArr[i];
		average = sum/(float) newArr.length;
		return average;
	}


	public static void main(String[] args) {
		int [] sco = {100, 88, 100, 100, 90};
		int[] sco2 = {34, 45, 67, 12, 17};
		float avg=0f;
		avg = getAvg(sco, sco2, 7);
		}
	}
