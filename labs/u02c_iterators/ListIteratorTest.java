import java.util.*;

public class ListIteratorTest {
	private ArrayList<String> list;
	private String toRemove, replaceWith;

	public ListIteratorTest(String line, String rem, String rep) {
		setTest(line, rem, rep);
	}

	public void setTest(String line, String rem, String rep) {
		list = new ArrayList<> (Arrays.asList(line.split(" ")));
		toRemove = rem;
		replaceWith = rep;
	}

	public void replace() {
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			if (it.next().equals(toRemove))
				it.set(replaceWith);
		}
	}

	public String toString() {
		return list.toString() + "\n";
	}
}