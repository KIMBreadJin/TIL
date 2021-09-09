package basic;

public class Car {
	
	private int number;
	
	private String driverName;
		
	int getNumber() {
		return this.number;
		}
	String getDriverName() {
			return this.driverName;
		}
void setNumber(int number) {
	this.number=number;
		}
		
void setDriverName(String driverName) {
	this.driverName=driverName;
		}
public void driving() {
	System.out.println("운전중이에요");
		}

	}

