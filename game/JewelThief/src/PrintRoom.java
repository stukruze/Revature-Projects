import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Formatter;

public class PrintRoom extends Rooms {

	String pic[] = new String[11];
	{
		pic[0] = "frontdoor.txt";
		pic[1] = "title.txt";
		pic[2] = "kitchen.txt";
		pic[3] = "lion.txt";
		pic[4] = "bedroom.txt";
		pic[5] = "livingroomlion.txt";
		pic[6] = "indoor.txt";
		pic[7] = "landryroom.txt";
		pic[8] = "livingroom.txt";
		pic[9] = "gameover.txt";
		pic[10] = "win.txt";
	}

	public static void inventory() {
		System.out.print("you currently have ");
		if (frontdoorkey == 1) {
			System.out.print("a front door key ");
		}
		if (steak == 1) {
			System.out.print("a raw steak ");
		}
		if (jbkey == 1) {
			System.out.print("a jewlery box key ");
		}
		if (jewels == 1) {
			System.out.print("the jewels ");
		}
		if (frontdoorkey == 0 && steak == 0 && jbkey == 0 && jewels == 0) {
			System.out.print("There is nothing in your inventory ");
		}
		System.out.println("\n");
		System.out.println("------------------------------------------------");
		System.out.println("enter a command");
		System.out.println("------------------------------------------------");
	}
	
	
	public static void help() {
	System.out.println("Key words are: check, look, feed, exit, inventory, and help");
	System.out.println("------------------------------------------------");
	System.out.println("enter a command");
	System.out.println("------------------------------------------------");
	}

	public void IR(int a) throws IOException {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println(new String(Files.readAllBytes(Paths.get(pic[a]))));
		for (int i = 0; i < 13; ++i)
			System.out.println();
	}
	
	public void HR(int a) throws IOException {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println(new String(Files.readAllBytes(Paths.get(pic[a]))));
	}

	public void PR(int a) throws IOException {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println(new String(Files.readAllBytes(Paths.get(pic[a]))));
		System.out.println("------------------------------------------------");
		System.out.println("enter a command");
		System.out.println("------------------------------------------------");
	}

	public void PR(int a, int b) throws IOException {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println(new String(Files.readAllBytes(Paths.get(pic[a]))));
		System.out.println(new String(Files.readAllLines(Paths.get("lines.txt")).get(b)));
		System.out.println("------------------------------------------------");
		System.out.println("enter a command");
		System.out.println("------------------------------------------------");
	}

	public void SR(int a, int b) throws IOException {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println(new String(Files.readAllBytes(Paths.get(pic[a]))));
		System.out.print(new String(Files.readAllLines(Paths.get("lines.txt")).get(b)));

	}

	@SuppressWarnings("resource")
	public void CR(int a, int b) throws IOException {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println(new String(Files.readAllBytes(Paths.get(pic[a]))));
		System.out.print(new String(Files.readAllLines(Paths.get("lines.txt")).get(b)));
		System.out.print(" ");
		Formatter fmt = new Formatter();
		Calendar cal = Calendar.getInstance();
		fmt = new Formatter();
		fmt.format("%tl:%tM", cal, cal);
		System.out.println(fmt);
		System.out.println("------------------------------------------------");
		System.out.println("enter a command");
		System.out.println("------------------------------------------------");
	}

}
