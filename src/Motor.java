
public class Motor extends Vehicle {

	public Motor(String brand, String name, String licenseNumber, String type, int topSpeed, int gasCap, int wheel,
			String motorType, int helm) {
		super(brand, name, licenseNumber, type, topSpeed, gasCap, wheel);
		this.motorType = motorType;
		this.helm = helm;
	}

	String motorType;
	int helm;

	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	public int getHelm() {
		return helm;
	}

	public void setHelm(int helm) {
		this.helm = helm;
	}

	@Override
	public void canDo() {
		System.out.println(name + " is standing!!!");
	}

}
