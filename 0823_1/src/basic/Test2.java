package basic;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		Map<String, Color> al = new HashMap<>();
		
		Color a = new Color();
		a.setGreen("홍길동");
		a.setRed("홍말자2");
		a.setBlue("김개똥3");
		al.put("홍길동",a);
	
		Color b = new Color();
		b.setGreen("홍길동1");
		b.setRed("홍말자3");
		b.setBlue("김개똥4");
		al.put("홍길동1",b);
		
		Color c = new Color();
		c.setGreen("홍길동2");
		c.setRed("홍말자4");
		c.setBlue("김개똥5");
		al.put("홍길동2",c);

		Color d = new Color();
		d.setGreen("홍길동3");
		d.setRed("홍말자5");
		d.setBlue("김개똥6");
		al.put("홍길동3",d);
		
		Color e = new Color();
		e.setGreen("홍길동4");
		e.setRed("홍말자6");
		e.setBlue("김개똥7");
		al.put("홍길동4",e);
		
		System.out.println("Key : 홍길동 " + "value : " +al.get("홍길동"));
		System.out.println("Key : 홍길동1 " + "value : "+al.get("홍길동1"));
		System.out.println("Key : 홍길동2 " + "value : "+al.get("홍길동2"));
		System.out.println("Key : 홍길동3 " + "value : "+al.get("홍길동3"));
		System.out.println("Key : 홍길동4 " + "value : "+al.get("홍길동4"));
	}

}
