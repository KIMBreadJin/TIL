package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Morning3 {

	public static void main(String[] args) {
		Cart a = new Cart();
		
		a.setAddress("미금");
		a.setAge(50);
		a.setGreen(false);
		a.setMath(40.3f);
		a.setTotal(1109.6f);
		System.out.println("주소 : " + a.getAddress() + " " + "나이 : " + a.getAge() + "그린 : " + a.getGreen());
		System.out.println("수학 : " + a.getMath() + "총점 : " + a.getTotal());

		String[] address = {"미금","정자","부산","대구","제주도"};
		Map<String,Cart> carts = new HashMap();
		
		boolean flag= true;
		for (int i = 0; i<address.length; i++) {
			a = new Cart();
			a.setAddress(address[i]);
			a.setAge(3*(i+1));
			flag = !flag;
			a.setGreen(flag);
			a.setMath(3.7f*(i+2));
			a.setTotal(120.7f*(i+5)*2);
			carts.put(""+i , a);
		}
		Set<String> t = carts.keySet();
		t.forEach(i->System.out.println(t));
		for( String i : t) {
			System.out.println("주소 : " + carts.get(i).getAddress());
			System.out.println("나이 : " + carts.get(i).getAge());
			System.out.println("그린 : " + carts.get(i).getGreen());
			System.out.println("수학 : " + carts.get(i).getMath());
			System.out.println("총점 : " + carts.get(i).getTotal());
		}
	}

}
