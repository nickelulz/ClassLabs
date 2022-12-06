import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.*;

public class Lab16b {
  public static void main (String[] args) {
		try {
			// read from the file
			Scanner file = new Scanner(new File("lab16b.dat"));
			// make a new table
			HashTable table = new HashTable(10);
			file.nextLine();
			// load stuff into the table
			while (file.hasNextLine())
				table.add(new Word(file.nextLine().trim()));
			// print out the table
			System.out.println(table);
		}
		catch (FileNotFoundException io_err) {
			io_err.printStackTrace();
			System.out.println("Could not load HashTable.");
		}
  }
}