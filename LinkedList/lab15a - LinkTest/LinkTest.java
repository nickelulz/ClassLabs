import java.util.LinkedList;
import static java.lang.System.*;

public class LinkTest {
	private LinkedList<Integer> list;

	public LinkTest() {
		list = new LinkedList<Integer>();
	}

	public LinkTest(int[] nums) {
		list = new LinkedList<Integer>();
		for (int num : nums) {
			list.add(num);
		}
	}

	public double getSum() {
		return list.stream().mapToInt(Integer::intValue).sum();
	}

	public double getAvg() {
		return getSum()/list.size();
	}

	public int getLargest() {
		if (list.isEmpty())
			return -1;
		return list.stream().mapToInt(Integer::intValue).max().getAsInt();
	}

	public int getSmallest() {
		if (list.isEmpty())
			return -1;
		return list.stream().mapToInt(Integer::intValue).min().getAsInt();
	}

	public String toString() {
		StringBuilder out = new StringBuilder()
			.append("SUM:: " + getSum() + "\n")
			.append("AVERAGE::" + getAvg() + "\n")
			.append("SMALLEST:: " + getSmallest() + "\n")
			.append("LARGEST:: " + getLargest() + "\n");
		return out.toString();
	}
}