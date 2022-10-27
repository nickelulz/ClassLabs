import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class Lab06d {
	public static void main ( String[] args ) throws IOException {
		Scanner in = new Scanner(new File("lab06d.dat"));
		ArrayList<SiteName> sites = new ArrayList<>();
		in.nextLine(); // numlines
		while (in.hasNextLine())
			sites.add(new SiteName(in.nextLine()));
		System.out.println(sites);
	}
}
