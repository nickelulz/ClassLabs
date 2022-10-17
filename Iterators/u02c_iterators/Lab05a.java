import java.util.*;

public class Lab05a {
	public static void main(String[] args) {
		String[] tests = {
				"a b c a b c a",
				"a b c d e f g h i j x x x",
				"1 2 3 4 5 6 a b c a b c"
		};

		String[] test_keys = { "a", "x", "b" };

		for (int i = 0; i < tests.length; i++)
			test(tests[i], test_keys[i]);
	}

	static void test(String test, String key) {
		IteratorTest t = new IteratorTest(test, key);
		t.remove();
		System.out.println(t);
	}
}