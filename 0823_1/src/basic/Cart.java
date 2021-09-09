package basic;

public class Cart {
	

		private int age;
		private float math;
		private float total;
		private boolean green;
		private String address;
		
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public float getMath() {
			return math;
		}
		public void setMath(float math) {
			this.math = math;
		}
		public float getTotal() {
			return total;
		}
		public void setTotal(float total) {
			this.total = total;
		}
		public boolean getGreen() {
			return green;
		}
		public void setGreen(boolean green) {
			this.green = green;
		}
		
		public int getSize(String a) {
			 return a.length();
		}
	}

