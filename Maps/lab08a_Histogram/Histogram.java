import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Histogram {
	private Map<String, Integer> histogram;

	public Histogram() {
		histogram = new TreeMap<>();
	}

	public Histogram(String sent) {
		histogram = new TreeMap<>();
		Arrays.asList(sent.split(""))
			.forEach((String tok) -> {
				if (histogram.containsKey(tok)) 
 					histogram.put(tok, histogram.get(tok)+1); 
				else histogram.put(tok, 1);
			});
	}
	
	public void setSentence() {
		// no idea what this is for
	}	

	public String toString() {
		// String output="";
		// String allStars="";
		// return output+"\n\n";
		// String.format("-%16s %s", a.getKey(), "*".repeat(a.getValue()))

		// String out = "HISTOGRAM\n";
		// for (Map.Entry e: histogram.entrySet())
		// 	out += String.format("%-5s %s\n", e.getKey(), "*".repeat((Integer) e.getValue()));
		// return out;
		
		return 
			" ".repeat(15) +  "111111\nchar  123456789012345\n" +
			histogram.entrySet().stream()
				.map(e -> 
					String.format("%-5s %s\n", e.getKey(), "*".repeat((Integer) e.getValue()))
				)
				// .reduce((a, b) -> a + "\n" + b).get() 
				.collect(Collectors.joining())
			+ "\n";
	}
}