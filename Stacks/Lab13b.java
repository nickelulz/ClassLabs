import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Lab13b {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("Lab13BInput.dat"));
		while (in.hasNextLine()) {
			String exp = in.nextLine();
			System.out.println(exp + (SyntaxChecker.checkExpression(exp) ? " is correct." : " is incorrect."));
		}
		in.close();
	}
}