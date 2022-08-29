//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab01a {
	public static void main( String args[] ) throws IOException {
		Scanner in = new Scanner(new File("lab01a.dat"));
		in.nextInt();
		while (in.hasNextInt()) {
			PascalsTriangle t = new PascalsTriangle(in.nextInt());
			t.createTriangle();
			System.out.println(t);
		}
	}
}