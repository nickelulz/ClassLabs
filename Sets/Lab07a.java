import static java.lang.System.*;
import java.util.*;

public class Lab07a
{
	public static void main( String args[] )
	{
		String[] test_cases = {
				"a b c d e f g h a b c d e f g h i j k",
				"one two three one two three six seven one two",
				"1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"
		};

		for (String test_case: test_cases)
			test(test_case);
	}

	public static void test(String test) {
		System.out.println("Original List : " + test);
		out.println("Uniques : " + UniquesDupes.getUniques(test));
		out.println("Dupes : " + UniquesDupes.getDupes(test) + "\n\n");
	}
}