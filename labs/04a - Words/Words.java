import java.util.*;
import java.io.*;
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
		words = new ArrayList<>(Arrays.stream(wordList.split(" ")).map(s -> new Word(s)).collect(Collectors.toList()));
	}
	
	public int countWordsWithXChars(int size) {
		int count = 0;

		for (Word w: words)
			if (w.getLength() >= size)
				count++;

		return count;
	}
	
	public void removeWordsWithXChars(int size) {
		for (int i = words.size()-1; i >= 0; i--)
			if (words.get(i).getLength()>=size)
				words.remove(i);
	}

	public int countWordsWithXVowels(int numVowels) {
		int count=0;

		for (Word w: words)
			if (w.getNumVowels() >= numVowels)
				count++;

		return count;
	}
	
	public String toString() {
	   return words.toString().substring(1, words.toString().length()-1);
	}
}