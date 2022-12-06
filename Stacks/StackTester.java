import java.util.*;
import java.util.stream.*;
import java.io.*;

public class StackTester {
	private Stack<String> stack;

	public StackTester() {
		setStack("");
	}

	public StackTester(String line) {
		setStack(line);
	}

	public void setStack(String line) {
		stack = new Stack();
		String[] tokens = line.split(" ");
		for (String tok: tokens)
			stack.push(tok);
	}

	public String popEmAll() {
		String out = "popping all items in the stack\n";
		while (!stack.isEmpty())
			out += stack.pop() + " ";
		return out;
	}

	public String toString() {
		return stack.toString() + "\n" + popEmAll() + "\n";
	}
}