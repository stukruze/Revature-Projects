package main;

import java.util.Scanner;

public class Converter {

	static double cups, tea, miles, kilo, usgal, impgal;

	public static void cup(double cups) {
		tea = cups * 48;
		System.out.println("The Number of Teaspoons in " + cups + " Cups" + " is " + tea + "\n");
	}

	public static void tea(double tea) {
		cups = tea / 48;
		System.out.println("The Number of Cups in " + tea + " Teaspoons" + " is " + cups + "\n");
	}

	public static void mile(double miles) {
		kilo = miles * 1.609347218694;
		System.out.println("The Number of Kilometers in " + miles + " miles" + " is " + kilo + "\n");
	}

	public static void kilo(double miles) {
		miles = kilo / 1.609347218694;
		System.out.println("The Number of Miles in " + kilo + " Kilometers" + " is " + miles + "\n");
	}

	public static void us(double usgal) {
		impgal = usgal * 0.83267384;
		System.out.println("The Number of Imperial Gallons in " + usgal + " US Gallons" + " is " + impgal + "\n");
	}

	public static void imperial(double impgal) {
		usgal = impgal / 0.83267384;
		System.out.println("The Number of US Gallons in " + impgal + " Imperial Gallons" + " is " + usgal + "\n");
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int menuSelection = 0;

		while (menuSelection != 4) {
			System.out.println("Please select an option:\n");
			System.out.print("1.) Cups to Teaspoons or Teaspoons to Cups \n");
			System.out.print("2.) Miles to Kilometers or Kilometers to Miles \n");
			System.out.print("3.) US Gallons to Imperial Gallons or Imperial Gallons to US Gallons \n");
			System.out.print("4.) Quit \n");
			System.out.print("\n Enter Your Menu Choice: ");

			menuSelection = input.nextInt();

			switch (menuSelection) {

			case 1:

				int pick1 = 0;
				System.out.println("Enter 1 for Cups to Teaspoons ");
				System.out.println("Enter 2 for Teaspoons to Cups ");
				pick1 = input.nextInt();
				do {
					if (pick1 == 1) {
						System.out.print("Please Enter The Number of Cups: ");
						cups = input.nextDouble();
						cup(cups);
					} else if (pick1 == 2) {
						System.out.print("Please Enter The Number of Teaspoons: ");
						tea = input.nextDouble();
						tea(tea);
					} else {
						System.out.println("This is not a valid Menu Option! Please Select Another");
					}
				} while (pick1 != 1 && pick1 != 2);
				break;

			case 2:

				int pick2 = 0;
				System.out.println("Enter 1 for Miles to Kilometers ");
				System.out.println("Enter 2 for Kilometers to Miles ");
				pick2 = input.nextInt();
				do {
					if (pick2 == 1) {
						System.out.println("\nPlease Enter The Number of Miles: ");
						miles = input.nextDouble();
						mile(miles);
					} else if (pick2 == 2) {
						System.out.println("\nPlease Enter The Number of Kilometers: ");
						kilo = input.nextDouble();
						kilo(kilo);
					} else {
						System.out.println("This is not a valid Menu Option! Please Select Another");
					}
				} while (pick2 != 1 && pick2 != 2);
				break;
			case 3:

				int pick3 = 0;
				System.out.println("Enter 1 for US Gallons to Imperial Gallons ");
				System.out.println("Enter 2 for Imperial Gallons to US Gallons ");
				pick3 = input.nextInt();
				do {
					if (pick3 == 1) {
						System.out.println("Please Enter The Number of US Gallons ");
						usgal = input.nextDouble();
						us(usgal);
					} else if (pick3 == 2) {
						System.out.println("Please Enter The Number of Imperial Gallons ");
						impgal = input.nextDouble();
						imperial(impgal);
					} else {
						System.out.println("This is not a valid Menu Option! Please Select Another");
					}
				} while (pick3 != 1 && pick3 != 2);
				break;
			case 4: 
				System.out.println("Quitting Program ");
				break;
			default:
				System.out.println("This is not a valid Menu Option! Please Select Another");
				break;

			}

		}
		input.close();
	}
}
