import static java.lang.System.*;

public class SpiralMatrix
{
	private int[][] g;

	public SpiralMatrix() {
		setSize(0);
	}

	public SpiralMatrix(int size) {
		setSize(size);
		createSpiral();
	}
	
	public void setSize(int size) {
		g = new int[size][size];
	}

	public void createSpiral() {
		int size = g.length, row = 0, col = 0, val = 1, touched = 0;

		do {

			for (int d = 0; d < size; d++) {
				g[row][col] = val;
				
				if (row < size-1 && g[row+1][col] == 0)
					row++;
				else break;

				val++;
			}

			for (int r = 0; r < size; r++) {
				g[row][col] = val;

				if (col < size-1 && g[row][col+1] == 0)
					col++;
				else break;
				
				val++;
			}

			for (int u = 0; u < size; u++) {
				g[row][col] = val;

				if (row > 0 && g[row-1][col] == 0)
					row--;
				else break;

				val++;
			}

			for (int l = 0; l < size; l++) {
				g[row][col] = val;

				if (col > 0 && g[row][col-1] == 0)
					col--;
				else break;

				val++;
			}
		} while (touched++ <= size * size);
	}

	public String toString() {
		String output="";
		for (int r = 0; r < g.length; r++) {
			for (int c = 0; c < g.length; c++)
				output += g[r][c] + "\t";
			output += "\n";
		}
		return output;
	}
}