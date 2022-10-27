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
		return other.numVowels() - this.numVowels();
	}

	public String toString() {
		return str;
	}
}