import java.util.*;

public class Lab04e {
	public static void main(String args[]) {
		String[] expressions = {
				"3 + 5",
				"3 * 5",
				"3 - 5",
				"3 / 5",
				"5 / 5 * 2 + 8 / 2 + 5",
				"5 * 5 + 2 / 2 - 8 + 5 * 5 - 2"
		};

		Arrays.stream(expressions).forEach(Lab04e::test);
	}

	static void test(String exp) {
		ExpressionSolver expsolver = new ExpressionSolver(exp);
		expsolver.solveExpression();
		System.out.println(exp + " = " + expsolver + "\n");
	}
}