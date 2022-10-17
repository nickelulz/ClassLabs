public class Lab09b {
	public static void main(String args[]) {
		AtCounter a = new AtCounter();
		System.out.println(a);

		int[][] test_cases = new int[][] {
				{ 0, 0 },
				{ 2, 5 },
				{ 5, 0 },
				{ 9, 9 },
				{ 3, 9 },
		};

		for (int[] coordinate: test_cases)
			test(a, coordinate);
	}

	static void test(AtCounter counter, int[] coordinate) {
		counter.countAts(coordinate[0], coordinate[0]);
		System.out.println("(" + coordinate[0] + ", " + coordinate[1] + ") has " + counter.end_counter() + " @s connected.\n");
		System.out.println(counter + "\n\n");
	}
}