public class Lab09a {
	public static void main(String[] args) {
		int[][] test_cases = {
				{ 16, 	256  },
				{ 1000, 2000 },
				{ 1254, 2546 },
				{ 214, 	356  },
				{ 90, 	99   },
				{ 21, 	28   },
				{ 55, 	5    },
				{ 315, 	211  }
		};

		test(test_cases);
	}

	public static void test(int[][] values) {
		for (int i = 0; i < values.length; i++) {
			int a = values[i][0], b = values[i][1];
			System.out.printf("%-16s ------ %d\n", "GCF(" + a + "," + b + ")", GCF.gcf(a,b));
		}
	}
}