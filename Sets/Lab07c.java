import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab07c {
	public static void main( String args[] ) throws IOException {
		Scanner in = new Scanner(new File("lab07c.dat"));
		for (int i = 0; i < 3; i++)
			test(in.nextLine(), in.nextLine());
	}

	public static void test(String a, String b) {
		MathSet obj = new MathSet(a, b);
		System.out.println(obj);
		System.out.println("union - " + obj.union());
		System.out.println("intersection - " + obj.intersection());
		System.out.println("difference A-B - " + obj.differenceAMinusB());
		System.out.println("difference B-A - " + obj.differenceBMinusA());
		System.out.println("symmetric difference - " + obj.symmetricDifference() + "\n\n");
	}
}