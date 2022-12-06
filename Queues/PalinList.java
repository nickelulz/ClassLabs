import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PalinList {
	private Queue<String> queue;
	private Stack<String> stack;

	public PalinList() {
		setList("");
	}

	public PalinList(String list) {
		setList(list);
	}

	public void setList(String list) {
		queue = new LinkedList();
		stack = new Stack();
		for (String token: list.split(" ")) {
			queue.add(token);
			stack.push(token);
		}
	}

	public boolean isPalin() {
		while (!queue.isEmpty() && !stack.isEmpty())
			if (!queue.remove().equals(stack.pop()))
				return false;
		return true;
	}

	public String toString() {
		return queue.toString();
	}
}