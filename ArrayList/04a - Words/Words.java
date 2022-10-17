import java.util.*;
import java.util.stream.*;

class Words {
	private ArrayList<Word> words;

	public Words() {
		setWords("");
	}

	public Words(String wordList) {
		setWords(wordList);
	}

	public void setWords(String wordList) {
		words = (ArrayList<Word>)
				Arrays.stream(wordList.split(" "))
						.map(s -> new Word(s))
						.collect(Collectors.toList());
	}
	
	public int countWordsWithXChars(int size) {
		return (int) words.stream().filter(w -> w.getLength() == size).count();
	}
	
	public void removeWordsWithXChars(int size) {
		words = (ArrayList<Word>) words.stream().filter(w -> w.getLength() != size).collect(Collectors.toList());
	}

	public int countWordsWithXVowels(int numVowels) {
		return (int) words.stream().filter(w -> w.getNumVowels() == numVowels).count();
	}
	
	public String toString() {
	   return words.toString();
	}
}