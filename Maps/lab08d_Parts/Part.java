import java.util.regex.*;

public class Part implements Comparable<Part> {

	// Air Filter 98765 Chevy Silverado 2002
	private String 
		make, 		// Chevy 
		model, 		// Silverado
		part; 		// Air Filter
	private int 
		partNumber, // 98765
		year;		// 2002

	public static int indexOf(Pattern pattern, String s) {
	    Matcher matcher = pattern.matcher(s);
	    return matcher.find() ? matcher.start() : -1;
	}

	public Part(String line) {
		try {
			int pN_index = indexOf(Pattern.compile("\\d"), line);
			// Air Filter
			part = line.substring(0, pN_index);
			// 98765 Chevy Silverado 2002
			String[] tokens = line.substring(pN_index).split(" ");
			partNumber = Integer.parseInt(tokens[0]);
			make = tokens[1];
			model = tokens[2];
			year = Integer.parseInt(tokens[3]);
		}

		catch (Exception e) {
			System.out.println("REGEX FAILURE.");
			System.exit(0);
		}
	}

	public int compareTo(Part other) {
		if (!this.make.equals(other.make))
			return this.make.compareTo(other.make);
		if (!this.model.equals(other.model))
			return this.model.compareTo(other.model);
		if (!this.part.equals(other.part))
			return this.part.compareTo(other.part);
		return this.year - other.year;
	}

	// Chevy Silverado 2002 Air Filter 98765
	public String toString() {
		return String.format("%s %s %d %s %d", 
			make, model, year, part, partNumber);
	}
}