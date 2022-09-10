//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab01b
{
	public static void main( String args[] ) throws IOException {
		Scanner in = new Scanner(new File("labs/01b_FancyWord/" + "lab01b.dat"));
		in.nextLine();
		while (in.hasNextLine()) {
			System.out.println(new FancyWord(in.nextLine()).toString());
		}
	}
}