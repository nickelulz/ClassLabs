import static java.lang.System.*;
import java.util.Arrays;

public class FancyWord
{
	private char[][] mat;

	public FancyWord() {
		mat = new char[0][0];
	}

	public FancyWord(String word) {
		final int length = word.length();
		mat = new char[length][length];
		Arrays.stream(mat).forEach(e -> Arrays.fill(e, ' '));
		for (int i = 1; i < length; i++)
			mat[i][i] = mat[length-1-i][i] = word.charAt(i); 
		mat[0] = mat[length-1] = word.toCharArray();
	}

	public String toString() {
		String output="";
		for (int a = 0; a < mat.length; a++) {
			for (int b = 0; b < mat.length; b++)
				output += mat[a][b] + " ";
			output += "\n";
		}
		return output;
	}
}