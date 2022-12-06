import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab08c {
	public static void main( String args[] ) throws IOException {
		/* 
			Almas is related to Brian
			Bob is related to John Tom
			Dot is related to Chuck Fred Jason Tom
			Elton is related to Linh
			Fred is related to Alice James
			Jim is related to Sally Tammy Tom
			Timmy is related to Amanda
			Dot is related to [Chuck, Fred, Jason, Tom]
			Is Dot directly related to Tom? Yes
			Is Dot directly related to Alice? No 
		*/
		Relatives relatives = new Relatives();
		Scanner in = new Scanner(new File("lab08c.dat"));
		int lines = in.nextInt();
		in.nextLine();
		for (int i = 0; i < lines; i++)
			relatives.setPersonRelative(in.nextLine());
		System.out.println(relatives);
		System.out.println(relatives.getRelatives("Dot"));
		System.out.println(relatives.checkRelated("Dot", "Tom"));
		System.out.println(relatives.checkRelated("Dot", "Alice"));
	}
}