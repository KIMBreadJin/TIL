package green;

public class ScoreTest {

	public static void main(String[] args) {
		Score[] scores = new Score[5];
		String [] names = {"홀길동 ", "홍말자 ","김개똥 ","김말자 ","홍개똥 "};
		float total = 0.0f;
		float avg = 0.0f;
		float kravg = 0.0f;
		float mtavg = 0.0f;
		float enavg = 0.0f;
		String ka = "";
		int cnt = 0;
		String fname="";
		for(int i=0; i<scores.length;i++) scores[i] =new Score();
		for(int i=0; i<scores.length;i++) {
			scores[i].setKorea((int)(Math.random()*100));
			scores[i].setEng((int)(Math.random()*100));
			scores[i].setMath((int)(Math.random()*100));
			scores[i].setName(names[i]);
			total = scores[i].getKorea() + scores[i].getMath() + scores[i].getEng();
			scores[i].setTotal(total);
			avg=total/3.0f;
			scores[i].setAvg(avg);
		}
		for(int i=0; i<scores.length; i++) {
			scores[i].setGrade(scores[i].calcGrade(scores[i].getAvg()));
			
			if(scores[i].getGrade() == "가") {
				//System.out.printf("%s님은 '가'입니다\n",scores[i].getName());
				fname += scores[i].getName();
				cnt++;
			}
			
		}
		for(int i=0; i<scores.length; i++) {
			kravg += scores[i].getKorea();
			mtavg += scores[i].getMath();
			enavg += scores[i].getEng();
			}
		System.out.println("국어 평균 : " + (kravg/scores.length));
		System.out.println("수학 평균 : " + (mtavg/scores.length));
		System.out.println("영어 평균 : " + (enavg/scores.length));
		System.out.printf("성적이 '가'인 학생은 %d명 입니다",cnt);
		System.out.printf("성적인 '가'인 학생의 이름 \n %s " , fname);
	}

}
