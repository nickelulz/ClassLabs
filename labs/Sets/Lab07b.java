import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab07b {
	public static void main( String args[] ) throws IOException {
		Scanner in = new Scanner(new File("lab07b.dat"));
		while (in.hasNextLine())
			System.out.println(new OddEvenSets(in.nextLine()));
	}
}