//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab04b {
	public static void main(String args[]) {
		String[] tests = {
				"5 12 9 6 1 4 8 6",
				"5 12 3 7 28 496 81 65 33 11",
				"1 2 3 4 5 6 7 8 11 13 151 16 17 18 19 20"
		};

		Arrays.stream(tests).forEach(Lab04b::test);
	}

	static void test(String t) {
		NumberAnalyzer test = new NumberAnalyzer(t);
		out.println(test);
		out.println("odd count = "+test.countOdds());
		out.println("even count = "+test.countEvens());
		out.println("perfect count = "+test.countPerfects()+"\n\n\n");
	}
}