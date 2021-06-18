import java.io.IOException;
import java.util.Scanner;

public class Rooms {

	static String str = "";
	static String str2 = "";
	static double n = 0;
	static double n2 = 0;
	protected static Scanner myObj = new Scanner(System.in);

	static int frontdoorkey = 0;
	static int lion = 0;
	static int next = 0;
	static int steak = 0;
	static int jbkey = 0;
	static int jewels = 0;
	static PrintRoom r = new PrintRoom();

	static void intro() throws IOException {

		r.IR(1);
		System.out.println("Key words are: check, look, feed, exit, inventory, and help");
		System.out.println("\n");
		System.out.println("press enter to start");
		str = myObj.nextLine();
		Room1();
	}

	static void Room1() throws IOException {
		r.PR(0);
		next = 0;
		while (next == 0) {

			if (jewels == 1) {
				r.IR(10);
			}

			str = myObj.nextLine();

			if (str.equals("look")) {
				r.PR(0, 0);
			} else if (str.equals("check rock")) {
				r.PR(0, 2);
				frontdoorkey = 1;
			} else if (str.equals("check door")) {
				if (frontdoorkey == 0) {
					r.PR(0, 1);
				} else {
					r.PR(0, 3);
					Room2();
					next = 1;
				}
			} else if (str.equals("inventory")) {
				r.HR(0);
				PrintRoom.inventory();
			} else if (str.equals("help")) {
				r.HR(0);
				PrintRoom.help();
			} else {
				r.PR(0);
				System.out.println("invalid command");
			}
		}
	}

	static void Room2() throws IOException {
		r.PR(6);
		next = 0;
		while (next == 0) {

			str = myObj.nextLine();

			if (str.equals("look")) {
				r.PR(6, 4);
			} else if (str.equals("check clock")) {
				r.CR(6, 5);
			} else if (str.equals("check door to the left") || str.equals("check left door")) {
				Room3();
			} else if (str.equals("check door straight ahead")) {
				Room4();
			} else if (str.equals("check stairs")) {
				Room6();
			} else if (str.equals("exit")) {
				next = 1;
				Room1();
			} else if (str.equals("inventory")) {
				r.HR(6);
				PrintRoom.inventory();
			} else if (str.equals("help")) {
				r.HR(6);
				PrintRoom.help();
			} else {
				r.PR(6);
				System.out.println("invalid command");
			}

		}
	}

	static void Room3() throws IOException {

		r.PR(2);
		next = 0;
		while (next == 0) {

			str = myObj.nextLine();

			if (str.equals("look")) {
				r.PR(2, 6);
			} else if (str.equals("check refrigerator")) {

				if (steak == 0) {
					r.PR(2, 7);
					steak = 1;
				} else {
					r.PR(2, 11);
				}

			} else if (str.equals("check oven")) {

				if (steak == 0) {
					r.PR(2, 8);
				} else {
					r.PR(2, 9);
					str2 = myObj.nextLine();
					if (str2.equals("yes")) {
						r.PR(2, 10);
						steak = 2;
					} else if (str2.equals("no")) {
						r.PR(2);
					} else {
						r.PR(2);
						System.out.println("invalid command");
					}
				}

			} else if (str.equals("check sink")) {

				System.out.println("How many times do you want to wash the dishes, enter a number? ");
				n = myObj.nextDouble();
				r.PR(2);
				System.out.println("How many dishes do you want to wash, enter a number? ");
				n2 = myObj.nextDouble();
				r.PR(2);
				System.out.print(mathfun.math(n, n2));
				System.out.println(" seconds");
				System.out.println("------------------------------------------------");
				System.out.println("enter a command");
				System.out.println("------------------------------------------------");
				str = myObj.nextLine();

			} else if (str.equals("exit")) {
				next = 1;
				Room2();

			} else if (str.equals("inventory")) {
				r.HR(2);
				PrintRoom.inventory();
			} else if (str.equals("help")) {
				r.HR(2);
				PrintRoom.help();
			} else {
				r.PR(2);
				System.out.println("invalid command");
			}
		}
	}

	static void Room4() throws IOException {

		if (lion == 0) {
			r.PR(5);
		} else {
			r.PR(8);
		}
		next = 0;
		while (next == 0) {

			str = myObj.nextLine();

			if (str.equals("look")) {
				if (lion == 0) {
					r.PR(5, 13);
				} else {
					r.PR(8, 16);
				}
			} else if (str.equals("check door")) {
				if (lion == 0) {
					r.SR(3, 14);
					System.out.println("\n");
					System.out.println("press enter to continue");
					str = myObj.nextLine();
					r.IR(9);
					System.out.println("press enter to restart");
					str = myObj.nextLine();
					frontdoorkey = 0;
					lion = 0;
					next = 0;
					steak = 0;
					next = 1;
					intro();
				} else {
					Room5();
				}
			} else if (str.equals("feed lion steak") || str.equals("feed lion")) {
				steak = 1;
				lion = 1;
				r.PR(8, 15);
			} else if (str.equals("exit")) {
				next = 1;
				Room2();
			} else if (str.equals("inventory")) {
				if (lion == 0) {
					r.HR(5);
				} else {
					r.HR(8);
				}
				PrintRoom.inventory();
			} else if (str.equals("help")) {
				if (lion == 0) {
					r.HR(5);
				} else {
					r.HR(8);
				}
				PrintRoom.help();
			} else {
				if (lion == 0) {
					r.PR(5);
				} else {
					r.PR(8);
				}
				System.out.println("invalid command");
			}
		}
	}

	static void Room5() throws IOException {

		r.PR(7);
		next = 0;
		while (next == 0) {

			str = myObj.nextLine();

			if (str.equals("look")) {
				r.PR(7, 17);
			} else if (str.equals("check washer")) {
				r.PR(7, 22);
			} else if (str.equals("check dryer")) {
				jbkey = 1;
				r.PR(7, 18);
			} else if (str.equals("exit")) {
				Room4();
			} else if (str.equals("inventory")) {
				r.HR(7);
				PrintRoom.inventory();
			} else if (str.equals("help")) {
				r.HR(7);
				PrintRoom.help();
			} else {
				r.PR(7);
				System.out.println("invalid command");
			}
		}

	}

	static void Room6() throws IOException {

		r.PR(4);
		next = 0;
		while (next == 0) {

			str = myObj.nextLine();

			if (str.equals("look")) {
				r.PR(4, 19);
			} else if (str.equals("check jewelry box")) {
				if (jbkey == 0) {
					r.PR(4, 21);
				} else {
					jewels = 1;
					r.PR(4, 20);
				}
			} else if (str.equals("check bed")) {
				r.PR(4, 24);
			} else if (str.equals("exit")) {
				Room2();
			} else if (str.equals("inventory")) {
				r.HR(4);
				PrintRoom.inventory();
			} else if (str.equals("help")) {
				r.HR(4);
				PrintRoom.help();
			} else {
				r.PR(4);
				System.out.println("invalid command");
			}
		}

		
	}
}
