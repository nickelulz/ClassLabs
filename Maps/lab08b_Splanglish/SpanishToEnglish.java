import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;

public class SpanishToEnglish {
	private Map<String, String> pairs;

	public SpanishToEnglish() {
		pairs = new TreeMap<>();
	}

	public void putEntry(String entry) {
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
	}

	public String translate(String sent) {
		return Arrays.stream(sent.split(" ")).map(str -> pairs.get(str)).reduce((a, b) -> a + " " + b).get();
	}

	public String toString() {
		return pairs.toString().replaceAll("\\,","\n");
	}
}