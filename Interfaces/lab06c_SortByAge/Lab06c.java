import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class Lab06c {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new File("Interfaces/lab06c_SortByAge/" + "lab06c.dat"));
		ArrayList<Person> people = new ArrayList<>();
		in.nextLine();
		while (in.hasNextLine())
			people.add(new Person(in.nextInt(), in.nextInt(), in.nextInt(), in.nextLine()));
		Collections.sort(people);
		System.out.println(people.toString().replaceAll("\\[|\\]|,",""));
	}
}