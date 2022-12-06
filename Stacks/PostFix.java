import java.util.*;
import java.util.stream.*;
import java.io.*;

public class PostFix {
	private static double calc(double one, double two, String op) {
		// System.out.println("calculation: " + one + " " + op + " " + two);
		switch (op) {
		case "*":
			return two * one;
		case "%":
			return two % one;
		case "+":
			return two + one;
		case "/":
			return two / one;
		case "-":
			return two - one;
		default:
			return Double.MIN_VALUE;
		}
	}

	public static double solve(String expr) throws IllegalArgumentException {
		Queue<String> expression = new LinkedList<>(Arrays.asList(expr.split(" ")));
		Stack<Double> numbers = new Stack<Double>();
		// System.out.println(numbers + " " + expression);
		int count = 0;
		while (!expression.isEmpty()) {
			String next = expression.remove();
			// number check
			if (next.matches("[0-9]+[\\.]?[0-9]*"))
				numbers.push(Double.parseDouble(next));
			// operator check
			else if (next.matches("[*%+/-]")) {
				if (numbers.size() < 2)
					throw new IllegalArgumentException("Invalid Input, too many or incorrect ordering of operators.");
				numbers.push(calc(numbers.pop(), numbers.pop(), next));
			}
			// System.out.println(++count + ": " + numbers + " " + expression);
		}
		if (numbers.size() != 1) {
			// System.out.println(numbers + " " + expression);
			throw new IllegalArgumentException("Invalid Input, too many or incorrect ordering of numbers.");
		}
		return numbers.pop();
	}
}