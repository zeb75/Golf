package utilies;

import java.util.Scanner;

public class UserInput {

	private static Scanner sc = new Scanner(System.in);

	public static double getDouble(double min, double max) {

		double input = 1;

		while (true) {

			try {
				input = sc.nextDouble();
				if (input >= min && input <= max) {
					return input;
				} else {
					System.out.println("Enter a number between " + min + " and " + max);
				}
			}

			catch (Exception e) {
				System.out.println("Incorrect input");
				sc.nextLine();
			}

		}
	}
	
	public static int getInt(int min, int max) {

		int input = 1;

		while (true) {

			try {
				input = sc.nextInt();
				if (input >= min && input <= max) {
					return input;
				} else {
					System.out.println("Enter a number between " + min + " and " + max);
				}
			}

			catch (Exception e) {
				System.out.println("Incorrect input");
				sc.nextLine();
			}

		}
	}
	
	public static double round (double value, int precision) {
	    int scale = (int) Math.pow(10, precision);
	    return (double) Math.round(value * scale) / scale;
	}
}
