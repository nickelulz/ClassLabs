import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Lab14a {
	public static void main (String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Lab14aInput.dat"));
		while (in.hasNextLine()) {
			PalinList test = new PalinList(in.nextLine());
			System.out.printf("%s is %s.\n", test.toString(), test.isPalin() ? "a palinlist" : "not a palinlist");
		}
	}
}