public class Lab14b {
	public static void main (String[] args) {	

		final String[] tests = new String[] {
			"one seven six two three four five",
			"one two three four five 1 2 3 4 5",
			"a b c d e f g h i j k l m n o p",
			"p o n m l k j i h g f e d c b a"
		};

		for (String test: tests) {
			PQTester tester = new PQTester(test);
			System.out.println("toString() - " + tester.toString());
			System.out.println("getMin() - " + tester.getMin());
			System.out.println("getNaturalOrder() - " + tester.getNaturalOrder());
			System.out.println("toString() - " + tester.toString() + "\n");
		}
	}
}