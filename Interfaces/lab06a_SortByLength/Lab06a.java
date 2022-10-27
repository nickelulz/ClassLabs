import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Lab06a {
	public static void main(String args[]) throws IOException {
		ArrayList<Word> words = new ArrayList<>();
		Scanner in = new Scanner(new File("lab06a.dat"));
		while (in.hasNextLine())
			words.add(new Word(in.nextLine()));
		Collections.sort(words);
		for (Word word: words)
			System.out.println(word);
	}
}