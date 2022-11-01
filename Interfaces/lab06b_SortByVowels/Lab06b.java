import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab06b {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new File("Interfaces/lab06b_SortByVowels/" + "lab06b.dat"));
		ArrayList<VowelWord> vwords = new ArrayList<>();
		while (in.hasNextLine())
			vwords.add(new VowelWord(in.nextLine()));
		Collections.sort(vwords);
		System.out.println(
				vwords.toString()
				.replaceAll("\\[|\\]","")
				.replaceAll(", ","\n")
		);
	}
}