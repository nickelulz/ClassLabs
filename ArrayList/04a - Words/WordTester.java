import java.util.Arrays;

public class WordTester {
	public static void main(String[] args) {
		String[] tests = { "chicken", "alligator", "elephant" };
		Arrays.stream(tests).forEach(WordTester::test);
	}

	static void test(String s) {
		Word w = new Word(s);
		System.out.println(s);
		System.out.println("num vowels == " + w.getNumVowels());
		System.out.println("num chars == " + w.getLength() + "\n\n");
	}
}