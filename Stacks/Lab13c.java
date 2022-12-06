import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Lab13c {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new File("Lab13CInput.dat"));
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			try {
				System.out.printf("%s = %.1f\n", line, PostFix.solve(line));
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		in.close();
	}
}