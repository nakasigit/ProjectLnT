
public class Car extends Vehicle {

	public Car(String brand, String name, String licenseNumber, String type, int topSpeed, int gasCap, int wheel,
			String carType, int enteSys) {
		super(brand, name, licenseNumber, type, topSpeed, gasCap, wheel);
		this.carType = carType;
		this.enteSys = enteSys;
	}

	String carType;
	int enteSys;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getEnteSys() {
		return enteSys;
	}

	public void setEnteSys(int enteSys) {
		this.enteSys = enteSys;
	}

	@Override
	public void canDo() {

		System.out.println("Turning on entertainment system...");
		
		if (carType.equals("Supercar")) {
			System.out.println("Boosting!!!");
		}
		
	}

}
