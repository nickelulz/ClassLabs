public class Word
{
	private String word;
	private static String vowels = "AEIOUaeiou";

	public Word() {
		setWord("");
	}

	public Word(String wrd) {
		setWord(wrd);
	}

	public void setWord(String wrd) {
		word = wrd;
	}
	
	public int getNumVowels() {
		return (int) word.chars().filter(c -> vowels.contains((char) c + "")).count();
	}
	
	public int getLength() {
		return word.length();
	}

	public String toString() {
	   return word;
	}
}