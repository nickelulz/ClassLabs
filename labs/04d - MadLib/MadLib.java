//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	// add in three ArrayList instance variables
	// 1 for nouns, 1 for adjectives, and 1 for verbs
	private ArrayList<String> nouns, adjectives, verbs;
	private String madlib, original;
	private static final String PATH = "labs/04d - MadLib/";

	{
		nouns = new ArrayList<>();
		adjectives = new ArrayList<>();
		verbs = new ArrayList<>();
		madlib = "";
	}

	public MadLib() {

	}

	public MadLib(String fileName)  {
		loadAdjectives();
		loadNouns();
		loadVerbs();

		try {
			Scanner file = new Scanner(new File(PATH + fileName));
			madlib = file.nextLine();
			original = madlib;
			file.close();
			generate();
		} catch(Exception e) {
			out.println("Houston we have a problem!");
		}
	}

	public void reset() {
		madlib = original;
	}

	public void generate() {
		while (madlib.contains("#")) // noun
			madlib = madlib.replaceFirst("#", getRandomNoun());
		while (madlib.contains("@")) // verb
			madlib = madlib.replaceFirst("@", getRandomVerb());
		while (madlib.contains("&")) // adj
			madlib = madlib.replaceFirst("&", getRandomAdjective());
	}

	public void loadNouns()  {
		try {
			Scanner noun_io = new Scanner(new File(PATH + "nouns.dat"));
			while (noun_io.hasNextLine())
				nouns.add(noun_io.nextLine());
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void loadVerbs() {
		try {
			Scanner verbs_io = new Scanner(new File(PATH + "verbs.dat"));
			while (verbs_io.hasNextLine())
				verbs.add(verbs_io.nextLine());
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void loadAdjectives() {
		try {
			Scanner adj_io = new Scanner(new File(PATH + "adjectives.dat"));
			while (adj_io.hasNextLine())
				adjectives.add(adj_io.nextLine());
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public String getRandomVerb() {
		return verbs.get((int)(Math.random() * verbs.size()));
	}
	
	public String getRandomNoun() {
		return nouns.get((int)(Math.random() * nouns.size()));
	}
	
	public String getRandomAdjective() {
		return adjectives.get((int)(Math.random() * adjectives.size()));
	}		

	public String toString()
	{
	   return madlib + "\n\n\n";
	}
}