package com.games;

import utilies.UserInput;
import java.util.List;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		double toCup = 450;// Length of the course
		int userOption = 0;

		while (userOption != 2) {

			userOption = displayOptions();
			
			if (userOption == 2) {
				
				break;
			}

			else if (userOption == 1) {
				
				List<Double> resultList = new ArrayList<Double>(); // List where to save swings taken.

				try {

					System.out.println("You have a total of 9 swings");
					System.out.println("\nThe length of the course is " + toCup + " meters");

					for (int shoot = 1; shoot <= 9; shoot++) {
						System.out.println("\nEnter a number between 1-90 to set the angle: ");
						double angle = UserInput.getDouble(1, 90);

						System.out.println("\nEnter a number between 1-70 to set the velocity: ");
						double velocity = UserInput.getDouble(1, 70);
						toCup = Math.abs(distance(angle, velocity) - toCup); // Remaining distance
						toCup = UserInput.round(toCup, 3);

						resultList.add(distance(angle, velocity)); // list for the distance

						if (toCup < 451 && toCup > 0.1) {
							
							System.out.println("\nThe ball travelled: " + distance(angle, velocity) + " Meters");
							System.out.println("Remaining distance to the Cup: " + toCup + " Meters");

						}

						else if (toCup <= 0.1) {

							System.out.println(
									"|||Congratulations|||\n||||The ball went into the cup||||");
							break;
						}

						else if (toCup > 450) {
							throw new Exception();
						}

					}
				} catch (Exception e) {
					System.out.println("OUT OF BOUNDS");
					System.out.println("...Game over...");
				}

				System.out.println("\t\t\t\t\t\t  *Your swings*");

				for (int i = 0; i < resultList.size(); i++) // for Numbering the list
				{
					System.out.println("\t\t\t\t\t\tSwing " + (i + 1) + " : " + resultList.get(i) + " Meter");
				}

			}

		}

	}

	static double distance(double angle, double velocity) // the distance calculation
	{

		final double GRAVITY = 9.8;
		double angleInRadians = (Math.PI / 180) * angle;
		double distance = Math.pow(velocity, 2) / GRAVITY * Math.sin(2 * angleInRadians);
		distance = UserInput.round(distance, 3);
		return distance;
	}

	static int displayOptions() // Menu
	{

		System.out.println("<<<Gulf>>>");

		System.out.println("1-Start the game\n2-Quit");

		int optionsValue = UserInput.getInt(0,3);

		return optionsValue;

	}
}
