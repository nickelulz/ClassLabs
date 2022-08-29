import static java.lang.System.*;

import java.io.*;
import java.util.*;

public class Lab01d {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("lab01d.dat"));
		int n = in.nextInt();
		for (int i = 0; i < n; i++)
			System.out.println(new SpiralMatrix(in.nextInt()));
	}
}