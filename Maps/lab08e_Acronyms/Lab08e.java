import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab08e {
	public static void main(String args[]) throws IOException {
		/*
		====
		MAP CONTENTS
		====
		{CPU=Central Processing Unit
		FG=Field Goal
		HD=Hard Drive
		PDA=Personal Display of Affection
		PU=Pick Up
		RBI=Runs Batted In
		SO=Strike Out
		TSO=Texas State Optical}
		====
		READ LINES
		====
		I drove my Pick Up to Texas State Optical to get a Hard Drive. My
		Central Processing Unit has a virus. I sometimes Strike Out
		when trying to kick a Field Goal. I had 2 Runs Batted In
		at the game. I saw 2 Personal Display of Affection
		infractions in the hall. 
		*/

		System.out.println("============");
		System.out.println("MAP CONTENTS");
		System.out.println("============\n");

		Acronyms acr = new Acronyms();
		Scanner in = new Scanner(new File("lab08e.dat"));
		int lines = in.nextInt();
		in.nextLine();
		for (int i = 0; i < lines; i++)
			acr.putEntry(in.nextLine());
		System.out.println(acr + "\n");

		System.out.println("==========");
		System.out.println("READ LINES");
		System.out.println("==========\n");

		while (in.hasNextLine())
			System.out.println(acr.convert(in.nextLine()));

		in.close();
	}
}