import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;

public class Relatives {
	private Map<String,Set<String>> map;

	public Relatives() {
		map = new TreeMap<>();
	}

	public void setPersonRelative(String line) {
		String[] pair = line.split(" ");
		if (!map.containsKey(pair[0]))
			map.put(pair[0], new TreeSet<String>());
		map.get(pair[0]).add(pair[1]);
	}


	public String getRelatives(String person) {
		return person + " is related to " + (map.containsKey(person) ? 
			map.get(person) == null || map.get(person).isEmpty() ? 
			"Nobody." : 
			map.get(person).stream().reduce((a,b) -> a + ", " + b).get() : 
		"Person " + person + " not found.");
	}

	public String checkRelated(String personA, String personB) {
		return String.format("Is %s directly related to %s? %s", 
			personA, personB, map.get(personA).contains(personB) ? "Yes" : "No");
	}


	public String toString() {
		// return map.entrySet().stream()
		// 	.map(e -> String.format(
		// 		"%s is related to %s", e.getKey(), 
		// 		e.getValue() == null || e.getValue().isEmpty() ? "Nobody" : 
		// 		e.getValue().stream().reduce((a,b) -> a + ", " + b).get()
		// 	))
		// 	.reduce((a, b) -> a + "\n" + b).orElse("Empty.");
		return map.keySet().stream().map(person -> getRelatives(person)).reduce((a,b) -> a + "\n" + b).get();
	}
}