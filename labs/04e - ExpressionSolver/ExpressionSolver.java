import java.util.*;

public class ExpressionSolver {
	ArrayList<String> expression;

	public ExpressionSolver(String s) {
		setExpression(s);
	}

	public void setExpression(String s) {
		expression = new ArrayList<> (Arrays.asList(s.split(" ")));
	}

	public void solveExpression() {
		while (expression.contains("*") || expression.contains("/")) {
			int op_pos = -1, multiply_pos = expression.indexOf("*"), divide_pos = expression.indexOf("/");
			if (multiply_pos > 0 && divide_pos > 0)
				op_pos = Math.min(multiply_pos, divide_pos);
			else if (multiply_pos > 0 && divide_pos < 1)
				op_pos = multiply_pos;
			else
				op_pos = divide_pos;

			int op1 = Integer.parseInt(expression.get(op_pos-1));
			int op2 = Integer.parseInt(expression.get(op_pos+1));
			String op = expression.get(op_pos);
			int result = (op.equals("*")) ? op1 * op2 : op1 / op2;
			expression.remove(op_pos-1);
			expression.remove(op_pos-1);
			expression.set(op_pos-1, String.valueOf(result));
		}

		while (expression.contains("+") || expression.contains("-")) {
			int op_pos = -1, add_pos = expression.indexOf("+"), subtract_pos = expression.indexOf("-");
			if (add_pos > 0 && subtract_pos > 0)
				op_pos = Math.min(add_pos, subtract_pos);
			else if (add_pos > 0 && subtract_pos < 1)
				op_pos = add_pos;
			else
				op_pos = subtract_pos;

			int op1 = Integer.parseInt(expression.get(op_pos-1));
			int op2 = Integer.parseInt(expression.get(op_pos+1));
			String op = expression.get(op_pos);
			int result = (op.equals("+")) ? op1 + op2 : op1 - op2;
			expression.remove(op_pos-1);
			expression.remove(op_pos-1);
			expression.set(op_pos-1, String.valueOf(result));
		}
	}

	public String toString() {
		return expression.get(0);
	}
}