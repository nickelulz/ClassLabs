import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList {
	private TreeMap<Part, Integer> partsMap;
	
	public PartList() {
		partsMap = new TreeMap<>();
	}
	
	public PartList(String fileName) {
		this();

		try {
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNextLine()) {
				Part next = new Part(file.nextLine());
				if (!partsMap.containsKey(next))
					partsMap.put(next, 0);
				partsMap.put(next, partsMap.get(next)+1);
			}
		} 

		catch(IOException | RuntimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public String toString() {
		return partsMap.entrySet().stream()
			.map(e -> e.getKey().toString() + " - " + e.getValue())
			.reduce((a,b) -> a + "\n" + b).orElse("None.");
	}
}