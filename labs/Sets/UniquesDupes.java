import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes {
	public static Set<String> getUniques(String input) {
		Set<String> uniques = new TreeSet<>();
		for (String s: input.split(" "))
			uniques.add(s);
		return uniques;
	}

	public static Set<String> getDupes(String input) {
		Set<String> uniques = new TreeSet<>();
		Set<String> dups = new TreeSet<>();
		for (String s: input.split(" "))
			if (!uniques.add(s))
				dups.add(s);
		return dups;
	}
}
