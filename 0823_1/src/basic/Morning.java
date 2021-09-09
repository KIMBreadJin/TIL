package basic;

import java.util.ArrayList;
import java.util.List;

public class Morning {

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
		List<Cart> carts = new ArrayList<Cart>();
		boolean flag= true;
		for (int i = 0; i<address.length; i++) {
			a = new Cart();
			a.setAddress(address[i]);
			a.setAge(3*(i+1));
			flag = !flag;
			a.setGreen(flag);
			a.setMath(3.7f*(i+2));
			a.setTotal(120.7f*(i+5)*2);
			carts.add(a);
		}
		for(Cart i : carts) {
			System.out.println("주소 : " + i.getAddress());
			System.out.println("나이 : " + i.getAge());
			System.out.println("그린 : " + i.getGreen());
			System.out.println("수학 : " + i.getMath());
			System.out.println("총점 : " + i.getTotal());
		}
	}

}
