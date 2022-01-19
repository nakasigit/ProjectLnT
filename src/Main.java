import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Vehicle> vehicles = new Vector<>();

	public Main() {

		int menu = 0;

		do {

			System.out.println("Welcome to PT Musang Database");
			System.out.println("-----------------------------");
			System.out.println("1. Input new Vehicle");
			System.out.println("2. View Vehicle List");
			System.out.println("3. Exit");
			System.out.print(">> ");

			try {
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				menu = -1;
				clearLine();
				System.err.println("Please input a proper menu...");
				clearLine();
			}

			switch (menu) {

			case 1:

				menuInsert();

				break;

			case 2:

				menuView();

				break;

			}

		} while (menu != 3);

	}

	private void menuView() {

		int select = 0;

		do {
			clearLine();

			System.out.printf("|-----|---------------|---------------|\n");
			System.out.printf("|%-5s|%-15s|%-15s|\n", "No", "Type", "Name");
			System.out.printf("|-----|---------------|---------------|\n");

			for (int i = 0; i < vehicles.size(); i++) {
				System.out.printf("|%-5s|%-15s|%-15s|\n", (i + 1), vehicles.get(i).getType(),
						vehicles.get(i).getName());
			}

			System.out.printf("|-----|---------------|---------------|\n");
			System.out.println("Select a vehicle number to test drive [select '0' to exit]");
			System.out.print(">> ");

			try {
				select = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.err.println("Please input a proper vehicle...");
			}

			if (select < 1) {
				select--;

			} else if (select <= vehicles.size()) {
				select--;
				clearLine();
				System.out.println("Brand: " + vehicles.get(select).getBrand());
				System.out.println("Name: " + vehicles.get(select).getName());
				System.out.println("License Plate: " + vehicles.get(select).getLicenseNumber());
				System.out.println("Type: " + vehicles.get(select).getBrand());
				System.out.println("Gas Capacity: " + vehicles.get(select).getGasCap());
				System.out.println("Top Speed: " + vehicles.get(select).getTopSpeed());
				System.out.println("Wheel(s): " + vehicles.get(select).getWheel());

				if (vehicles.get(select).getType().equals("Car")) {
					Car car = (Car) vehicles.get(select);
					System.out.println("Entertainment System: " + car.getEnteSys());
				} else {
					Motor motor = (Motor) vehicles.get(select);
					System.out.println("Helm: " + motor.getHelm());
				}

				vehicles.get(select).canDo();

				if (vehicles.get(select).getType().equals("Motorcycle")) {
					Motor motor = (Motor) vehicles.get(select);
					int price = 0;
					System.out.print("Input price for helmet(s): ");
					price = scan.nextInt();
					scan.nextLine();
					System.out.println("Price: " + (motor.getHelm() * price));
				}
			}

		} while (select != -1);

		clearLine();

	}

	private void menuInsert() {

		String brand = "", name = "", licenseNumber = "", type = "";
		int topSpeed = 0, gasCap = 0, wheel = 0;

		clearLine();
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			type = scan.nextLine();
		} while (!(type.equalsIgnoreCase("Car") || type.equalsIgnoreCase("Motorcycle")));

		// tambahan validasi tambahan starts with capital setiap kata
		do {
			System.out.print("Input brand [5 Characters or more and starts with Capital]: ");
			brand = scan.nextLine();
		} while (brand.length() < 5 || isStartWithUpper(brand) == false);

		do {
			System.out.print("Input name [5 Characters or more and starts with Capital]: ");
			name = scan.nextLine();
		} while (name.length() < 5 || isStartWithUpper(name) == false);

		do {
			System.out.print("Input license: ");
			licenseNumber = scan.nextLine();
		} while (validateLicense(licenseNumber) == false);

		do {
			System.out.print("Input top speed [100 - 250]: ");
			topSpeed = scan.nextInt();
			scan.nextLine();
		} while (topSpeed < 100 || topSpeed > 250);

		do {
			System.out.print("Input gas capacity [30 - 60]: ");
			gasCap = scan.nextInt();
			scan.nextLine();
		} while (gasCap < 30 || gasCap > 60);

		if (type.equalsIgnoreCase("Car")) {

			String carType = "";
			int enteSys = 0;

			do {
				System.out.print("Input wheel [4 - 6]: ");
				wheel = scan.nextInt();
				scan.nextLine();
			} while (wheel < 4 || wheel > 6);

			do {
				System.out.print("Input car type [SUV | Supercar | Minivan]: ");
				carType = scan.nextLine();
			} while (!(carType.equals("SUV") || carType.equals("Supercar") || carType.equals("Minivan")));

			do {
				System.out.print("Input entertainment system amount [>= 1]: ");
				enteSys = scan.nextInt();
				scan.nextLine();
			} while (enteSys < 1);

			type = "Car";
			vehicles.add(new Car(brand, name, licenseNumber, type, topSpeed, gasCap, wheel, carType, enteSys));

		} else {

			String motorType = "";
			int helm = 0;

			do {
				System.out.print("Input wheel [2 - 3]: ");
				wheel = scan.nextInt();
				scan.nextLine();
			} while (wheel < 2 || wheel > 3);

			do {
				System.out.print("Input motor type [Automatic | Manual]: ");
				motorType = scan.nextLine();
			} while (!(motorType.equals("Automatic") || motorType.equals("Manual")));

			do {
				System.out.print("Input helm [>= 1]: ");
				helm = scan.nextInt();
				scan.nextLine();
			} while (helm < 1);

			type = "Motorcycle";
			vehicles.add(new Motor(brand, name, licenseNumber, type, topSpeed, gasCap, wheel, motorType, helm));

		}

		System.out.println("New " + type.toLowerCase() + " has been made");
		System.out.print("Press enter to continue...");
		scan.nextLine();
		clearLine();

	}

	private boolean validateLicense(String licenseNumber) {
		int count = 0;
		String[] temp = licenseNumber.split(" ", 3);

		if (temp.length == 3) {

			if (temp[0].matches("[A-Z]{1,2}?")) {
				count++;
			}

			if (temp[1].matches("[0-9]{1,4}?")) {
				count++;
			}

			if (temp[2].matches("[A-Z]{1,3}?")) {
				count++;
			}

		}

		if (count == 3) {
			return true;
		}

		return false;
	}

	private boolean isStartWithUpper(String input) {

		// pake regex
		String regex = "^[A-Z].*";
		Pattern pattern = Pattern.compile(regex);

		Matcher match = pattern.matcher(input);

		if (match.matches() == true) {
			return true;
		}

		/*
		 * pake isUpperCase
		 * 
		 * if (Character.isUpperCase(input.charAt(0))) { return true; }
		 * 
		 */

		return false;
	}

	private void clearLine() {
		System.out.printf("\n\n\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
