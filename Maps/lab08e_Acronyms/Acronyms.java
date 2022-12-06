import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Acronyms {
	private Map<String,String> acronymTable;

	public Acronyms() {
		acronymTable = new TreeMap<String, String>();
	}

	public void putEntry(String entry) {
		String[] tokens = entry.split(" - ");
		acronymTable.put(tokens[0], tokens[1]);
	}

	public String convert(String sent) {
		for (Map.Entry<String, String> e: acronymTable.entrySet())
			sent = sent
				.replaceAll(String.format(" %s ", e.getKey()), " " + e.getValue() + " ")
				.replaceAll(String.format(" %s.", e.getKey()), " " + e.getValue() + ".");
		return sent;
	}

	public String toString() {
		return acronymTable.toString()
			.replaceAll("[\\{\\}]","")
			.replaceAll(", ","\n");
	}
}