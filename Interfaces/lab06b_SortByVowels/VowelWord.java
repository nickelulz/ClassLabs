class VowelWord implements Comparable<VowelWord>
{
	private String str;

	public VowelWord(String str) {
		this.str = str;
	}

	private int numVowels() {
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (String s: str.split(""))
			if (vowels.contains(s))
				vowelCount++;
		return vowelCount;
	}

	public int compareTo(VowelWord other) {
		if (this.numVowels() != other.numVowels())
			return this.numVowels() - other.numVowels();
		else
			return this.str.compareTo(other.str);
	}

	public String toString() {
		return str;
	}
}