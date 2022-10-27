import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab06b {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new File("lab06b.dat"));
		ArrayList<VowelWord> vwords = new ArrayList<>();
		while (in.hasNextLine())
			vwords.add(new VowelWord(in.nextLine()));
		Collections.sort(vwords);
		System.out.println(vwords);
	}
}