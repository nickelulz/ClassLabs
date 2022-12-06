public class Word {
	private String value;
	private static final String vowels = "aeiou"; 

	// Write a constructor method
	public Word(String value) {
		this.value = value;
	}

	// Write the getValue method
	public String getValue() {
		return this.value;
	}

	// Write the equals method
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Word ? this.value.equals(((Word) obj).value) : false;
	}

	public int numVowels() {
		int count = 0;
		for (String character: value.toLowerCase().split(""))
			if (vowels.contains(character))
				count++;
		return count;
	}

	// Write the hashCode method
	@Override
	public int hashCode() {
		return numVowels() * value.length();
	}

	// Write the toString method
	public String toString() {
		return value;
	}
}