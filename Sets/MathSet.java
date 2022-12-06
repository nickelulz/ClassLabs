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

    public static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
		Set<Integer> union = new TreeSet<>(a);
		union.addAll(b);
		return union;
	}

	public Set<Integer> intersection() {
		TreeSet<Integer> intersection = new TreeSet<>(union(a,b));
		intersection.removeAll(differenceAMinusB(a, b));
		intersection.removeAll(differenceAMinusB(b, a));
		return intersection;
	}

    public static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
		TreeSet<Integer> intersection = new TreeSet<>(union(a,b));
		intersection.removeAll(differenceAMinusB(a, b));
		intersection.removeAll(differenceAMinusB(b, a));
		return intersection;
	}

	public Set<Integer> differenceAMinusB() {
		TreeSet<Integer> a_b = new TreeSet<>(a);
		a_b.removeAll(b);
		return a_b;
	}

	public static Set<Integer> differenceAMinusB(Set<Integer> a, Set<Integer> b) {
		TreeSet<Integer> a_b = new TreeSet<>(a);
		a_b.removeAll(b);
		return a_b;
	}

	public Set<Integer> differenceBMinusA() {
		TreeSet<Integer> b_a = new TreeSet<>(b);
		b_a.removeAll(a);
		return b_a;
	}

    public static Set<Integer> differenceBMinusA(Set<Integer> a, Set<Integer> b) {
		TreeSet<Integer> b_a = new TreeSet<>(b);
        b_a.removeAll(a);
		return b_a;
	}
	
	public Set<Integer> symmetricDifference() {
		TreeSet<Integer> sym_diff = new TreeSet<>();
		sym_diff.addAll(differenceAMinusB());
		sym_diff.addAll(differenceBMinusA());
		return sym_diff;
	}	

    public static Set<Integer> symmetricDifference(Set<Integer> a, Set<Integer> b) {
		TreeSet<Integer> sym_diff = new TreeSet<>();
		sym_diff.addAll(differenceAMinusB(a,b));
		sym_diff.addAll(differenceBMinusA(a,b));
		return sym_diff;
	}
	
	public String toString() {
		return "Set one " + a + "\n" +	"Set two " + b +  "\n";
	}
}
