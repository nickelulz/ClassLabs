import static java.lang.System.*;

public class PascalsTriangle 
{
	private int[][] mat;
	private int size;

	public PascalsTriangle() {
		this(0);
	}

	public PascalsTriangle(int size) {
		mat = new int[size][size];
		this.size = size;
	}

	public void createTriangle() {
		for (int i = 0; i < size; i++) {
			mat[i][i] = 1;
			mat[i][0] = 1;
		}

		for (int a = 1; a < size; a++)
			for (int b = 1; b < size; b++)
				mat[a][b] = mat[a-1][b-1] + mat[a-1][b];
	}

	@Override
	public String toString() {
		String out = "";
		for (int a = 0; a < size; a++) {
			for (int b = 0; b <= a; b++)
				out += mat[a][b] + "\t";
			out += '\n';
		}
		return out;
	}
}