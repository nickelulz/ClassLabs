import java.util.*;

public class Lab05b {
	public static void main ( String[] args ) {
		String[] test_lists = {
				"a b c a b c",
				"a b c d e f g h i j x x x x",
				"1 2 3 4 5 6 a b c a b c"
		};

		String[] test_to_replaces   = { "a", "x", "b" };
		String[] test_replace_withs = { "+", "7", "#" };

		for (int i = 0; i < test_lists.length; i++)
			test(test_lists[i], test_to_replaces[i], test_replace_withs[i]);
	}

	static void test(String list, String toReplace, String replaceWith) {
		ListIteratorTest test = new ListIteratorTest(list, toReplace, replaceWith);
		test.replace();
		System.out.println(test);
	}
}