import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Lab13a {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new File("Lab13aInput.dat"));
		while (in.hasNextLine())
			System.out.println(new StackTester(in.nextLine()));
		in.close();
	}
}
