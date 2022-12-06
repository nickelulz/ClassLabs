import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab08a {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("histogram.dat"));
		while (in.hasNextLine())
			System.out.println(new Histogram(in.nextLine()));
	}
}