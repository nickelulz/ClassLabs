import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab08b {
	public static void main( String args[] ) throws IOException {
		Scanner file = new Scanner(new File("lab08b.dat"));
		SpanishToEnglish test = new SpanishToEnglish();

		// read in pairs from the file and load the map
		out.println("\n====\tMAP CONTENTS\t====\n\n");
		int lines = file.nextInt();
		file.nextLine();
		for (int i = 0; i < lines; i++)
			test.putEntry(file.nextLine());
		
		// print the map
		out.println(test+"\n\n");
		
		// read in the lines and convert them
		while (file.hasNextLine())
			System.out.println(test.translate(file.nextLine()));
	}
}