import java.util.*;
import java.util.stream.Collectors;

public class IteratorTest {
	private ArrayList<String> list;
	private String toRemove;

	public IteratorTest(String line, String rem) {
		setTest(line, rem);
	}

	public void setTest(String line, String rem) {
		list = new ArrayList<>(Arrays.asList(line.split(" ")));
		toRemove = rem;
	}

	public void remove() {
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			if (it.next().equals(toRemove))
				it.remove();
		}
	}

	public String toString() {
		return list.toString();
	}
}