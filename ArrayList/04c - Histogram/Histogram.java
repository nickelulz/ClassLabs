//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()  {
	}

	public Histogram(char[] values, String fName) {
		letters = new ArrayList<>();
		count = new ArrayList<>();
		for (char c: values) {
			letters.add(c);
			count.add(0);
		}
		fileName = fName;
		out.println("search letters = "+ letters);
	}

	public void loadAndAnalyzeFile() throws IOException {
		Scanner in = new Scanner (new File("labs/04c - Histogram/" + fileName));

		// big o: o(n^3) :((((
		while (in.hasNextLine()) {
			for (char c: in.nextLine().toCharArray()) {
				for (int i = 0; i < letters.size(); i++) {
					if (c == letters.get(i))
						count.set(i, count.get(i) + 1);
				}
			}
		}

		in.close();
	}

	public char mostFrequent() {
		int largest = 0;
		for (int i = 0; i < count.size(); i++)
			if (count.get(i) > count.get(largest)) {
				largest = i;
			}
		return letters.get(largest);
	}

	public char leastFrequent() {
		int smallest = 0;
		for (int i = 0; i < count.size(); i++)
			if (count.get(i) < count.get(smallest))
				smallest = i;
		return letters.get(smallest);
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}