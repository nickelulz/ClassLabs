import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	{
		odds = new TreeSet<>();
		evens = new TreeSet<>();
	}

	public OddEvenSets(String line) {
		Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).forEach((int n) -> {
			if (n % 2 == 0)
				evens.add(n);
			else
				odds.add(n);
		});
	}

	public String toString() {
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}