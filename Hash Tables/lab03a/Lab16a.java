import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.*;

public class Lab16a {
  public static void main (String[] args) {
		try {
			// make a new table
			HashTable table = new HashTable(100);
			// read from the file
			Scanner file = new Scanner(new File("lab16a.dat"));
			// load stuff into the table
			while (file.hasNextInt())
				table.add(file.nextInt());
			// print out the table
			System.out.println(table);
		}
		catch (FileNotFoundException io_err) {
			io_err.printStackTrace();
			System.out.println("Could not load HashTable.");
		}
  }
}