import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class MathSet {
	private Set<Integer> a;
	private Set<Integer> b;

	{
		a = new TreeSet<>();
		b = new TreeSet<>();
	}

	public MathSet(String a, String b) {
		Arrays.stream(a.split(" ")).mapToInt(Integer::valueOf).forEach(e -> this.a.add(e));
		Arrays.stream(b.split(" ")).mapToInt(Integer::valueOf).forEach(e -> this.b.add(e));
	}

	public Set<Integer> union() {
		Set<Integer> union = new TreeSet<>(a);
		union.addAll(b);
		return union;
	}

	public Set<Integer> intersection() {
		Set<Integer> unique_all = union(), intersect = new TreeSet<>();
		for (Integer n: a)
			if (!unique_all.add(n))
				intersect.add(n);
		for (Integer n: b)
			if (!unique_all.add(n))
				intersect.add(n);
		return intersect;
	}

	public Set<Integer> differenceAMinusB() {
		TreeSet<Integer> a_b = new TreeSet<>(a);
		for (int n: intersection())
			a_b.remove(n);
		return a_b;
	}

	public Set<Integer> differenceBMinusA() {
		TreeSet<Integer> b_a = new TreeSet<>(a);
		for (int n: intersection())
			b_a.remove(n);
		return b_a;
	}
	
	public Set<Integer> symmetricDifference() {
		TreeSet<Integer> sym_diff = new TreeSet<>(differenceAMinusB());
		sym_diff.addAll(differenceBMinusA());
		return sym_diff;
	}	
	
	public String toString() {
		return "Set one " + a + "\n" +	"Set two " + b +  "\n";
	}
}