import java.util.*;
import java.io.*;

public class stats {
	Set<String> permutations;

	boolean valid(String str) {
		return str.charAt(0) == 'T' && !"AEIOU".contains(str.substring(str.length()-1));
	}

	void permute(ArrayList<String> out, ArrayList<String> in) {
		String str_vers = out.stream().reduce((a,b) -> a+b).orElse("");
		if (!out.isEmpty() && valid(str_vers))
			permutations.add(str_vers);
		if (in.isEmpty())
			return;

		// permute
		for (int i = 0; i < in.size(); i++) {
			String next = in.get(i);
			ArrayList<String> in_clone = (ArrayList<String>) in.clone();
			ArrayList<String> out_clone = (ArrayList<String>) out.clone();
			in_clone.remove(next);
			out_clone.add(next);
			permute(out_clone, in_clone);
		}
	}

	stats() {
		permutations = new HashSet<String>();
		permute(new ArrayList<String>(), new ArrayList<String>(Arrays.asList("STATISTICS".split(""))));
		System.out.println(permutations);
		System.out.println(permutations.size());
	}

	public static void main(String[] args) {
		new stats();
	}
}