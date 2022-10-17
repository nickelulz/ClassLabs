//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab04d
{
	public static void main( String args[] )
	{
		MadLib madlib = new MadLib("story.dat");
		for (int i = 0; i < 10; i++) {
			madlib.reset();
			madlib.generate();
			System.out.println(madlib);
		}
	}
}