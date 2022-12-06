import java.util.ArrayList;
import static java.lang.System.*;

public class IntQueue {
	private ArrayList<Integer> list;

	{
		list = new ArrayList();
	}

	public void add(int item) {
		list.add(item);
	}

	public int remove() {
		return list.remove(0);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int peek() {
		return list.get(0);
	}

	public String toString() {
		return list.toString();
	}
}