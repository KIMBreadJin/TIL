package green;

import java.util.ArrayList;
import java.util.List;

public class ScoreTest2 {

	public static void main(String[] args) {
	//	Score[] scores = new Score[5];
		List<Score> scores = new ArrayList<Score>();
		String [] names = {"홀길동 ", "홍말자 ","김개똥 ","김말자 ","홍개똥 "};
		float total = 0.0f;
		float avg = 0.0f;
		float kravg = 0.0f;
		float mtavg = 0.0f;
		float enavg = 0.0f;
		int korea, math, eng = 0;
		String ka = "";
		int cnt = 0;
		String fname="";
		int j = 0;
		//for(int i=0; i<scores.length;i++) scores[i] =new Score();
		for(int i=0; i<5;i++) {
			while(true) {
				korea =((int)(Math.random()*100));
				math = ((int)(Math.random()*100));
				eng = ((int)(Math.random()*100));
				if(korea>50 && math> 50 && eng>50) break;

		}
		Score a = new Score();
		a.setKorea(korea);
		a.setMath(math);
		a.setEng(eng);
		total = a.getKorea()+a.getMath()+a.getEng();
		a.setTotal(total);
		a.setAvg(total/3.0f);
		a.setName(names[j++]);
		a.setGrade(a.calcGrade(a.getAvg()));;
		scores.add(a);
	}
		int koreaAvg=0 , mathAvg=0, engAvg = 0;
		for(Score i : scores) System.out.println("국어 : " + i.getKorea() + "수학 : " + i.getMath() + "영어 : " + i.getEng());
		for(Score i : scores) {
			koreaAvg += i.getKorea();
			mathAvg += i.getMath();
			engAvg += i.getEng();
			
		}
		koreaAvg/=scores.size();
		mathAvg/=scores.size();
		engAvg/=scores.size();
		System.out.println("국어평균 : " + koreaAvg + " 수학평균 : " + mathAvg + " 영어 평균 : " + engAvg );
		for(Score i:scores) {
			if (i.getGrade().equals("수")) System.out.println("수 : " + i.getName());
			else if (i.getGrade().equals("우")) System.out.println("수 : " + i.getName());
			else if (i.getGrade().equals("미")) System.out.println("수 : " + i.getName());
			else if (i.getGrade().equals("양")) System.out.println("수 : " + i.getName());
			else System.out.println("가 : " + i.getName());
			
		}
		
	}
}
