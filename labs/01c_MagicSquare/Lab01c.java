import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lab01c {
	public static void main( String args[] ) throws FileNotFoundException {
		Scanner in = new Scanner(new File("lab01c.dat"));
		while (in.hasNextInt()) {
			System.out.println(new MagicSquare(in.nextInt()).toString());
		}
	}
}