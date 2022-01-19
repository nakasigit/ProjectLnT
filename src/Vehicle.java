
public abstract class Vehicle {
	
	String brand, name, licenseNumber, type;
	int topSpeed, gasCap, wheel;
	
	public Vehicle(String brand, String name, String licenseNumber, String type, int topSpeed, int gasCap, int wheel) {
		super();
		this.brand = brand;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.type = type;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
	}
	
	public abstract void canDo();
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicensenumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	public int getGasCap() {
		return gasCap;
	}
	public void setGasCap(int gasCap) {
		this.gasCap = gasCap;
	}
	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
}
