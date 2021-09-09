package basic;

public class Morning2 {

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
		Cart[] carts = new Cart[5];
		boolean flag= true;
		for (int i = 0; i<address.length; i++) {
			carts[i] = new Cart();
			carts[i].setAddress(address[i]);
			carts[i].setAge(3*(i+1));
			flag = !flag;
			carts[i].setGreen(flag);
			carts[i].setMath(3.7f*(i+2));
			carts[i].setTotal(120.7f*(i+5)*2);
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
