import static java.lang.System.*;

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
		int count = 0;
		for (char c: word.toCharArray())
			if (vowels.contains(c + ""))
				count++;
		return count;
	}
	
	public int getLength() {
		return word.length();
	}

	public String toString() {
	   return "";
	}
}